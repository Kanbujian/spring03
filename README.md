# spring03
##Spring 整合Hibernate实现基于数据库的用户信息管理##

1.包 
  commons.logging等spring基本依赖包
  dbcp pool collection
  AspectJ cglib等
  
  
2.model.addAttribute(String name，*)
  对于map list同样适用
  只要跟JSTL foreach items=${name}保持一致就可以了
  
  
3.list.contains(User u)
  会对list每个元素调用equals（u），若有一个返回true，则返true；遍历完毕没有返回true，则返回false
  这个地方只需要验用户名是否存在，故重写equals（）方法
  pulic boolean equals（Object o）{
    if(o isInstance User)
       return false;
    user u1=(user)o;   
    return this.username.equals(u1.getUsername());   
  }
  
4.css js images等静态资源应在webroot文件夹下面，与WEB-INF同级  
  
  

  
