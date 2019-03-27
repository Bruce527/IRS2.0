
PDL 下配置说明

config
	|_webservice.acc.properties
	|_webservice.hlt.properties
	
constants
	|_AccConstants.java + AccWSConstants.java
	|_HltConstants.java + HltWSConstants.java
	
这两个文件夹下配置文件和java类是一套即：
 北京将康险  webservice.hlt.properties HltConstants.java + HltWSConstants.java
 北京将康险  webservice.hlt.properties HltConstants.java + HltWSConstants.java
  
如果需要添加，则添加一套以下信息
XXX险  webservice.xxx.properties XxxConstants.java + XxxWSConstants.java 

其中唯一不同的是XxxWSContants.java 中 静态初始化时加载的文件不同，其实可以放在一个文件中进行分别加载
但是考虑到线程执行和不需要的不用加载原则（即单一职责原则）采用分别配置的方式，自己搞自己的