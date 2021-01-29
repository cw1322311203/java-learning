### 3.1静态资源和动态资源【理解】

![11_请求资源分类](https://img-blog.csdnimg.cn/20210129104327731.png)

+ 静态资源

  在服务器提前准备好的文件。(图片，文本)

  ![09_静态资源](https://img-blog.csdnimg.cn/20210129104002471.png)

+ 动态资源

  在图示的案例中，当用户点击了浏览器上的按钮。
  本质上访问的就是服务端的某一个类中的某一个方法。
  在方法中，可以写一些判断代码和逻辑代码，让响应的内容，有可能不一样了。
  那么，服务端所对应的这个类我们常常将其称之为“动态资源”

  ![10_动态资源](https://img-blog.csdnimg.cn/20210129104310857.png)

### 3.2准备工作【理解】

+ 修改四个地方

  + HttpResponse -> 常量WEB_APP_PATH的值与当前模块一致
  + HttpServer -> main方法中端口改成80
  + HttpResponse -> 添加一个write方法，添加一个带参数的构造方法
  + HttpResponse -> 添加一个contentType成员变量，生成对应的set/get方法

+ 示例代码

  ```java
  // 1.HttpResponse -> 常量WEB_APP_PATH的值与当前模块一致
  public class HttpResponse {
    ...
    public static final String WEB_APP_PATH = "http-dynamic-server\\webapp";
    ...
  }
  
  // 2.HttpServer -> main方法中端口改成80
  public class HttpServer {
    public static void main(String[] args) throws IOException {
      ...
      //2.让这个通道绑定一个端口
    	serverSocketChannel.bind(new InetSocketAddress(80));
      ...
    }
  }  
  
  // 3.HttpResponse -> 添加一个write方法，添加一个带参数的构造方法
  public class HttpResponse {
    ...
    // 已经提供了selectionKey，所以之前的方法接收这个参数的可以去掉了，直接使用这个即可
    // HttpRequest也按照此方式进行优化，定义成员变量，在构造方法中赋值，其他方法直接使用即可
    private SelectionKey selectionKey;
    
    public HttpResponse(SelectionKey selectionKey) {
          this.selectionKey = selectionKey;
      }
    
    //给浏览器响应数据的方法 ---- 浏览器在请求动态资源时,响应数据的方法.
    //content:响应的内容
    public void write(String content){
    }
    ...
  }
  
  public class HttpServer {
    public static void main(String[] args) throws IOException {
      ...
      //响应数据  //修改后的构造方法中要传入参数
      HttpResponse httpResponse = new HttpResponse(selectionKey);
      ...
    }
  }  
  
  // 4.HttpResponse -> 添加一个contentType成员变量，生成对应的set/get方法
  public class HttpResponse {
    ...
    private String contentType;//MIME类型
    
    public String getContentType() {
          return contentType;
      }
    public void setContentTpye(String contentType) {
          this.contentType = contentType;
          //添加到map集合中
          hm.put("Content-Type",contentType);
      }
    ...
  }
  ```

### 3.3浏览器请求动态资源【理解】

+ 两个小问题

  + 服务器如何判断浏览器请求的是静态资源还是动态资源?

    我们可以规定：如果浏览器地址栏中的uri是以”/servlet”开始的，那么就表示请求动态资源

  + 在一个项目中有很多类，很多方法。那么请求过来之后，执行哪个方法呢?

    写一个UserServlet类，在类中写service方法
    我们可以规定：如果请求动态资源，就创建这个类对象，并调用service方法，表示服务器处理了当前请求

+ 实现步骤

  1. 解析http请求

  2. 处理浏览器请求

     定义一个UserServlet 类，类中定义service方法，处理浏览器请求动态资源
     解析完http请求之后，再判断uri是否以/servlet开头

  3. 响应

+ 示例代码

  ```java
  public class UserServlet{
    public void service(){
          //模拟业务处理  ---- 就可以对这个手机号进行判断验证
          System.out.println("UserServlet处理了用户的请求...");
      }
  }
  public class HttpServer {
    public static void main(String[] args) throws IOException {
      	...
      	//响应数据
      	HttpResponse httpResponse = new HttpResponse(selectionKey);
          httpResponse.setHttpRequest(httpRequest);
  
          if(httpRequest.getRequestURI().startsWith("/servlet")){
            	//本次请求动态资源
            	//处理 
            	UserServlet userServlet = new UserServlet();
            	userServlet.service();
            	//响应
          	httpResponse.setContentTpye("text/html;charset=UTF-8");
          	httpResponse.write("ok,UserServlet处理了本次请求....");  
          }else{
            //本次请求静态资源
            httpResponse.sendStaticResource();
          }
      	...
    }
  } 
  
  public class HttpResponse {
    	...
  	//给浏览器响应数据的方法 ---- 浏览器在请求动态资源时,响应数据的方法.
      //content:响应的内容
      public void write(String content){
          //准备响应行数据
          this.version = "HTTP/1.1";
          this.status = "200";
          this.desc = "ok";
  
          //把响应行拼接在一起
          String responseLine = this.version + " " + this.status + " " + this.desc + "\r\n";
  
          //准备响应头
          StringBuilder sb = new StringBuilder();
          Set<Map.Entry<String, String>> entries = hm.entrySet();
          for (Map.Entry<String, String> entry : entries) {
              //entry依次表示每一个键值对对象
              //键 --- 响应头的名称
              //值 --- 响应头的值
              sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
          }
  
          //处理响应空行
          String emptyLine = "\r\n";
  
          //拼接响应行,响应头,响应空行
          String result = responseLine + sb.toString() + emptyLine;
  
          try {
              //给浏览器响应 响应行,响应头,响应空行
              ByteBuffer byteBuffer1 = ByteBuffer.wrap(result.getBytes());
              SocketChannel channel = (SocketChannel) selectionKey.channel();
              channel.write(byteBuffer1);
  
              //给浏览器响应 响应体
              ByteBuffer byteBuffer2 = ByteBuffer.wrap(content.getBytes());
              channel.write(byteBuffer2);
  
              //释放资源
              channel.close();
  
          } catch (IOException e) {
              System.out.println("响应数据失败....");
              e.printStackTrace();
          }
  
      }    
   	 ...
  }
  ```

### 3.4main方法和Servlet优化【理解】

+ main方法优化

  + 需求

    将请求动态资源的代码抽取到一个单独的类单独的方法中，简化main中的代码

  + 代码实现

    ```java
    public class DynamicResourceProcess {
      
        //执行指定动态资源的service方法
        //参数一
        //由于后期可能根据用户请求的uri做出相应的处理.
        //参数二
        //要给用户响应数据,那么就需要使用到httpResponse.
        public void process(HttpRequest httpRequest,HttpResponse httpResponse) {
            // 创建UserServlet对象,调用service方法,进行处理
            UserServlet userServlet = new UserServlet();
            userServlet.service();
    
            //给浏览器响应
            httpResponse.setContentTpye("text/html;charset=UTF-8");
            httpResponse.write("ok,UserServlet处理了本次请求....");
        }
    }
    
    public class HttpServer {
      public static void main(String[] args) throws IOException {
        	...
        	//响应数据
        	HttpResponse httpResponse = new HttpResponse(selectionKey);
            httpResponse.setHttpRequest(httpRequest);
    
            if(httpRequest.getRequestURI().startsWith("/servlet")){
              	//本次请求动态资源
           		DynamicResourceProcess drp = new DynamicResourceProcess();
                drp.process(httpRequest,httpResponse);
            }else{
              //本次请求静态资源
              httpResponse.sendStaticResource();
            }
        	...
      }
    } 
    ```

+ Servlet优化

  + 需求

    将给浏览器响应的代码写到Servlet中

  + 代码实现

    ```java
    public class UserServlet implements HttpServlet{
    
        //处理浏览器请求的方法
        //参数一
        //由于后期可能根据用户请求的uri做出相应的处理.
        //参数二
        //要给用户响应数据,那么就需要使用到httpResponse.
        public void service(HttpRequest httpRequest, HttpResponse httpResponse){
            //模拟业务处理  ---- 就可以对这个手机号进行判断验证
            System.out.println("UserServlet处理了用户的请求...");
            //给浏览器响应
            httpResponse.setContentTpye("text/html;charset=UTF-8");
            httpResponse.write("ok,UserServlet处理了本次请求....");
        }
    }
    
    public class DynamicResourceProcess {
      
        //执行指定动态资源的service方法
        //参数一
        //由于后期可能根据用户请求的uri做出相应的处理.
        //参数二
        //要给用户响应数据,那么就需要使用到httpResponse.
        public void process(HttpRequest httpRequest,HttpResponse httpResponse) {
            // 创建UserServlet对象,调用service方法,进行处理
            UserServlet userServlet = new UserServlet();
            userServlet.service(httpRequest,httpResponse);
        }
    }
    ```

### 3.5多个动态资源【理解】

+ 多个动态资源

  针对每一个业务操作，我们都会去定义一个对应的Servlet来完成。
  就会在服务端产生很多个Servlet

  ![12_多个动态资源](https://img-blog.csdnimg.cn/20210129104347429.png)

+ 实现步骤

  + 定义一个接口HttpServlet，接口中定义service方法。
  + 针对于每一种业务，都定义一个servlet类与之对应，该类实现HttpServlet接口
  + 获取请求的uri，进行判断，调用不同的servlet类中的service方法

+ 代码实现

  ```java
  // 1.定义一个接口HttpServlet，接口中定义service方法
  public interface HttpServlet {
  
      //定义业务处理的方法
      public abstract void service(HttpRequest httpRequest, HttpResponse httpResponse);
  }
  
  // 2.针对于每一种业务，都定义一个servlet类与之对应，该类实现HttpServlet接口
  public class UserServlet implements HttpServlet{
      //处理浏览器请求的方法
      //参数一
      //由于后期可能根据用户请求的uri做出相应的处理.
      //参数二
      //要给用户响应数据,那么就需要使用到httpResponse.
      public void service(HttpRequest httpRequest, HttpResponse httpResponse){
          //模拟业务处理  ---- 就可以对这个手机号进行判断验证
          System.out.println("UserServlet处理了用户的请求...");
          //给浏览器响应
          httpResponse.setContentTpye("text/html;charset=UTF-8");
          httpResponse.write("ok,UserServlet处理了本次请求....");
      }
  }
  
  public class LoginServlet implements HttpServlet{
      @Override
      public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
         //处理
          System.out.println("LoginServlet处理了登录请求");
         //响应
          httpResponse.setContentTpye("text/html;charset=UTF-8");
          httpResponse.write("登录成功");
      }
  }
  
  public class RegisterServlet implements HttpServlet{
      @Override
      public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
         //处理
          System.out.println("RegisterServlet处理了注册请求");
         //响应
          httpResponse.setContentTpye("text/html;charset=UTF-8");
          httpResponse.write("注册成功");
      }
  }
  
  public class SearchServlet implements HttpServlet{
      @Override
      public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
         //处理
          System.out.println("SearchServlet处理了搜索商品请求");
         //响应
          httpResponse.setContentTpye("text/html;charset=UTF-8");
          httpResponse.write("响应了一些商品信息");
      }
  }
  
  // 3.获取请求的uri，进行判断，调用不同的servlet类中的service方法
  public class DynamicResourceProcess {
    
      public void process(HttpRequest httpRequest,HttpResponse httpResponse){
            //获取请求的uri
            String requestURI = httpRequest.getRequestURI();
   
            //根据请求的uri进行判断
            if("/servlet/loginservlet".equals(requestURI)){
                //登录请求
                LoginServlet loginServlet = new LoginServlet();
                loginServlet.service(httpRequest,httpResponse);
            }else if("/servlet/registerservlet".equals(requestURI)){
                //注册请求
                RegisterServlet registerServlet = new RegisterServlet();
                registerServlet.service(httpRequest,httpResponse);
            }else if("/servlet/searchservlet".equals(requestURI)){
                //搜索商品请求
                SearchServlet searchServlet = new SearchServlet();
                searchServlet.service(httpRequest,httpResponse);
            }else{
                //表示默认处理方法
                //创建UserServlet对象,调用service方法,进行处理
                UserServlet userServlet = new UserServlet();
                userServlet.service(httpRequest,httpResponse);
            }
        }
  }
  ```

### 3.6通过反射和配置文件优化【理解】

+ 优化步骤

  1. 把Servlet信息写到properties配置文件中

     格式为：servlet-info=/servlet/UserServlet，全类名；/servlet/loginServlet，全类名

  2. 定义一个接口ServletConcurrentHashMap，接口中定义ConcurrentHashMap，该集合存储所有的servlet信息

  3. 定义一个接口ParseServletConfig，该接口中定义一个方法（parse）

  4. 定义ParseServletConfig的实现类，解析配置文件，并把配置文件中Servlet信息存到map集合中

  5. 在main方法的第一行，开启一条线程执行解析配置文件的代码

  6. 修改处理DynamicResourceProcess中的process方法

     ![13_反射和配置文件优化](https://img-blog.csdnimg.cn/20210129104408451.png)

+ 代码实现

  ```java
  // 1.把Servlet信息写到properties配置文件中
  // 在webapp\config\servlet-info.properties文件中，写入如下内容
  servlet-info=/servlet/loginservlet,com.itheima.myservlet.LoginServlet;/servlet/registerservlet,com.itheima.myservlet.RegisterServlet;/servlet/searchservlet,com.itheima.myservlet.SearchServlet;/servlet/lostpasswordservlet,com.itheima.myservlet.LostPasswordServlet
  
  // 2.定义一个接口ServletConcurrentHashMap，接口中定义ConcurrentHashMap，该集合存储所有的servlet信息
  public interface ServletConcurrentHashMap {
      //存储请求路径和对应的servlet的map集合
      //键: 请求的uri
      //值: 对应的Servlet对象
      public static final ConcurrentHashMap<String,  HttpServlet> map = new ConcurrentHashMap<>();
  }
  
  // 3.定义一个接口ParseServletConfig，该接口中定义一个方法（parse）
  public interface ParseServletConfig {
      //解析数据的方法
      public abstract void parse();
  }
  
  // 4.定义ParseServletConfig的实现类，解析配置文件，并把配置文件中Servlet信息存到map集合中
  public class PropertiesParseServletConfig implements ParseServletConfig {
      @Override
      public void parse() {
  
          try {
              //1.读取配置文件中的数据
              Properties properties = new Properties();
              FileReader fr = new FileReader("http-dynamic-server/webapp/config/servlet-info.properties");
              properties.load(fr);
              fr.close();
  
              //2.获取集合中servlet-info的属性值
              String properValue = (String) properties.get("servlet-info");
              // uri,全类名;uri,全类名
  
              //3.解析
              String[] split = properValue.split(";");
              for (String servletInfo : split) {
                  String[] servletInfoArr = servletInfo.split(",");
                  String uri = servletInfoArr[0];
                  String servletName = servletInfoArr[1];
  
                  //我们需要通过servletName(全类名)来创建他的对象
                  Class clazz = Class.forName(servletName);
                  HttpServlet httpServlet = (HttpServlet) clazz.newInstance();
                  //4.将uri和httpServlet添加到map集合中
                  ServletConcurrentHashMap.map.put(uri,httpServlet);
              }
          } catch (Exception e) {
              System.out.println("解析数据异常.....");
              e.printStackTrace();
          }
      }
  }
  
  public class LoaderResourceRunnable implements  Runnable {
      @Override
      public void run() {
          //执行parse方法
          ParseServletConfig parseServletConfig = new PropertiesParseServletConfig();
          parseServletConfig.parse();
          
      }
  }
  
  // 5.在main方法的第一行，开启一条线程执行解析配置文件的代码
  public class HttpServer {
      public static void main(String[] args) throws IOException {
          //开启一条线程去解析配置文件
          new Thread(new LoaderResourceRunnable()).start();
          ...
      }
  }
  
  // 6.修改处理DynamicResourceProcess中的process方法
  public class DynamicResourceProcess {
    
      public void process(HttpRequest httpRequest,HttpResponse httpResponse){
            	//获取请求的uri
            	String requestURI = httpRequest.getRequestURI();
            	//根据请求的uri到map集合中直接找到对应的servlet的对象
          	HttpServlet httpServlet = ServletConcurrentHashMap.map.get(requestURI);
              //调用service方法对请求进行处理并响应
              httpServlet.service(httpRequest,httpResponse);
      }
  }    
  ```

### 3.7Servlet忘记实现HttpServlet接口处理【理解】

+ 出现情况

  在写Servlet时，忘记了实现HttpServlet接口

+ 导致结果

  在反射创建对象后，强转成HttpServlet时，会报类型转换异常

+ 解决方案

  在反射创建对象后，强转成HttpServlet前，进行判断

  如果有实现HttpServlet接口，就进行强转

  否则抛出一个异常

+ 代码实现

  ```java
  public class PropertiesParseServletConfig implements ParseServletConfig {
      @Override
      public void parse() {
  
          try {
              //1.读取配置文件中的数据
              Properties properties = new Properties();
              FileReader fr = new FileReader("http-dynamic-server/webapp/config/servlet-info.properties");
              properties.load(fr);
              fr.close();
  
              //2.获取集合中servlet-info的属性值
              String properValue = (String) properties.get("servlet-info");
              // uri,全类名;uri,全类名
  
              //3.解析
              String[] split = properValue.split(";");
              for (String servletInfo : split) {
                  String[] servletInfoArr = servletInfo.split(",");
                  String uri = servletInfoArr[0];
                  String servletName = servletInfoArr[1];
  
                  //我们需要通过servletName(全类名)来创建他的对象
                  Class clazz = Class.forName(servletName);
  
                  //获取该类所实现的所有的接口信息,得到的是一个数组
                  Class[] interfaces = clazz.getInterfaces();
  
                  //定义一个boolean类型的变量
                  boolean flag =  false;
                  //遍历数组
                  for (Class clazzInfo : interfaces) {
                      //判断当前所遍历的接口的字节码对象是否和HttpServlet的字节码文件对象相同
                      if(clazzInfo == HttpServlet.class){
  
                          //如果相同,就需要更改flag值.结束循环
                          flag = true;
                          break;
                      }
                  }
  
                  if(flag){
                      //true就表示当前的类已经实现了HttpServlet接口
                      HttpServlet httpServlet = (HttpServlet) clazz.newInstance();
                      //4.将uri和httpServlet添加到map集合中
                      ServletConcurrentHashMap.map.put(uri,httpServlet);
                  }else{
                      //false就表示当前的类还没有实现HttpServlet接口
                      throw new NotImplementsHttpServletException(clazz.getName() + "Not Implements HttpServlet");
                  }
              }
          } catch (NotImplementsHttpServletException e) {
              e.printStackTrace();
          }catch (Exception e) {
              System.out.println("解析数据异常.....");
              e.printStackTrace();
          }
      }
  }
  
  ```

### 3.8响应404【理解】

+ 出现情况

  客户端浏览器请求了一个服务器中不存在的动态资源

+ 导致结果

  服务器中代码出现异常，程序停止

+ 解决方案

  如果请求的动态资源不存在，服务器根据请求的uri找到对应的Servlet时为null，继续调用方法会出现异常

  增加一个非空的判断，如果不为null，则继续处理请求，调用方法

  如果为null，则响应404

+ 代码实现

  ```java
  public class DynamicResourceProcess {
      //执行指定动态资源的service方法
      //参数一
      //由于后期可能根据用户请求的uri做出相应的处理.
      //参数二
      //要给用户响应数据,那么就需要使用到httpResponse.
      public void process(HttpRequest httpRequest,HttpResponse httpResponse){
          //获取请求的uri
          String requestURI = httpRequest.getRequestURI();
          //根据请求的uri到map集合中直接找到对应的servlet的对象
          HttpServlet httpServlet = ServletConcurrentHashMap.map.get(requestURI);
          if(httpServlet != null){
              //调用service方法对请求进行处理并响应
              httpServlet.service(httpRequest,httpResponse);
          }else{
              //浏览器请求的动态资源不存在
              //响应404
              response404(httpResponse);
          }
      }
      //浏览器请求动态资源不存在,响应404的方法
      private void response404(HttpResponse httpResponse) {
          try {
              //准备响应行
              String responseLine = "HTTP/1.1 404 NOT FOUND\r\n";
              //准备响应头
              String responseHeader = "Content-Type: text/html;charset=UTF-8\r\n";
              //准备响应空行
              String emptyLine = "\r\n";
              //拼接在一起
              String result = responseLine + responseHeader + emptyLine;
  
              //把响应行,响应头,响应空行去响应给浏览器
              SelectionKey selectionKey = httpResponse.getSelectionKey();
              SocketChannel channel = (SocketChannel) selectionKey.channel();
  
              ByteBuffer byteBuffer1 = ByteBuffer.wrap(result.getBytes());
              channel.write(byteBuffer1);
  
              //给浏览器 响应 响应体内容
              ByteBuffer byteBuffer2 = ByteBuffer.wrap("404 NOT FOUND....".getBytes());
              channel.write(byteBuffer2);
  
              //释放资源
              channel.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  

### 3.4改写服务器【理解】

+ 需求

  目前项目中Servlet和url对应关系,是配置在xml文件中的,将其改为在Servlet类上通过注解配置实现

+ 实现步骤

  1. 定义一个注解(@WebServlet),注解内有一个属性urlPatterns
  2. 在servlet类上去使用该注解,来指定当前Servlet的访问路径
  3. 创建一个注解解析类(AnnoParseServletConfig),该类实现ParseServletConfig接口
  4. 实现parse方法

+ 代码实现

  ```java
  @Target(ElementType.TYPE) //指定该注解可以使用在类上
  @Retention(RetentionPolicy.RUNTIME)//指定该注解的存活时间 --- 为运行期
  public @interface WebServlet {
  
      //让用户去指定某一个Servlet在进行访问的时候所对应的请求uri
      public String urlPatterns();
  }
  
  // 这里只给出了LoginServlet的配置,其他Servlet同理
  @WebServlet(urlPatterns = "/servlet/loginservlet")
  public class LoginServlet implements HttpServlet{
      @Override
      public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
         //处理
          System.out.println("LoginServlet处理了登录请求");
  
         //响应
          httpResponse.setContentTpye("text/html;charset=UTF-8");
          httpResponse.write("登录成功");
      }
  }
  
  public class AnnoParseServletConfig implements ParseServletConfig {
  
      //定义一个servlet路径所对应的常量
      public static final String SERVLET_PATH = "http-dynamic-server\\src\\com\\itheima\\myservlet";
    
      //定义包名
      public static final String SERVLET_PACKAGE_NAME = "com.itheima.myservlet.";
    
      @Override
      public void parse() {
          //获取类名
  //  1.获得servlet所在文件夹的路径，并封装成File对象
          File file = new File(SERVLET_PATH);
  //  2.调用listFiles方法，获取文件夹下所有的File对象
          File[] servletFiles = file.listFiles();
  //  3.遍历数组，获取每一个File对象
          for (File servletFile : servletFiles) {
  //  4.获取File对象的名字（后缀名）
              String servletFileName = servletFile.getName().replace(".java", "");
  //  5.根据包名 + 类名 得到每一个类的全类名
             String servletFullName = SERVLET_PACKAGE_NAME + servletFileName;
              try {
  //  6.通过全类名获取字节码文件对象
                  Class servletClazz = Class.forName(servletFullName);
                  //  7.判断该类是否有WebServlet注解
                  if(servletClazz.isAnnotationPresent(WebServlet.class)){
                  //  8.判断该Servlet类是否实现HttpServlet接口
                      //获取该类所实现的所有的接口信息,得到的是一个数组
                      Class[] interfaces = servletClazz.getInterfaces();
    
                      //定义一个boolean类型的变量
                      boolean flag =  false;
                      //遍历数组
                      for (Class clazzInfo : interfaces) {
                          //判断当前所遍历的接口的字节码对象是否和HttpServlet的字节码文件对象相同
                          if(clazzInfo == HttpServlet.class){
                              //如果相同,就需要更改flag值.结束循环
                              flag = true;
                              break;
                          }
                      }
    
                      if(flag){
                          //  9.如果满足，则获取注解中的urlPattrens的值，
                          WebServlet annotation = (WebServlet) servletClazz.getAnnotation(WebServlet.class);
                          String uri = annotation.urlPatterns();
    
                          //  10.创建当前Servlet类对象存入值位置
                          HttpServlet httpServlet = (HttpServlet) servletClazz.newInstance();
                          //  11.存入集合的键位置
                          ServletConcurrentHashMap.map.put(uri,httpServlet);
                          //
                      }else{
                          //  12.如果不满足，抛出异常
                          //false就表示当前的类还没有实现HttpServlet接口
                          throw new NotImplementsHttpServletException(servletClazz.getName() + "Not Implements HttpServlet");
                      }
                  }
              } catch (NotImplementsHttpServletException e) {
                  e.printStackTrace();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
  
          }
      }
  
  public class LoaderResourceRunnable implements  Runnable {
      @Override
      public void run() {
  //        //执行parse方法
  //        ParseServletConfig parseServletConfig = new PropertiesParseServletConfig();
  //        parseServletConfig.parse();
  
  //        ParseServletConfig parseServletConfig = new XMLParseServletConfig();
  //        parseServletConfig.parse();
  
          ParseServletConfig parseServletConfig = new AnnoParseServletConfig();
          parseServletConfig.parse();
    
      }
  }
  ```

