1. 项目中接口的主要 Demo 都在 Main.java 中, 引入 Springboot 也是为了写回调接口方便, 请查看 CallbackApplication
如需使用, 直接启动 CallbackApplication
2. 项目使用的工具类为 hutool. JSON 框架采用了 fastJson
3. 如不需要 springboot 框架, 可以直接使用 servlet 做接口
4. 请求梦网接口方式为 POST(建议生产环境使用连接池), 主要属性设置如下:
    "Accept-Charset" : "UTF-8"
    "Content-Type" : "application/json; charset=UTF-8"
    "accept" : "application/json"
    "Charset", "UTF-8"
5. 如有其它疑问, 请联系我们, 谢谢