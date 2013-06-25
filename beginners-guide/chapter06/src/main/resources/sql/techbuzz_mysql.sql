
CREATE DATABASE IF NOT EXISTS techbuzz;

USE techbuzz;

DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS posts_tags;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


CREATE TABLE users 
(
  user_id int(11) NOT NULL AUTO_INCREMENT,
  email_id varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  firstName varchar(255) DEFAULT NULL,
  lastName varchar(255) DEFAULT NULL,
  gender varchar(10) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  dob datetime DEFAULT NULL,
  disabled tinyint(1) NULL,
  bio LONGTEXT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY email_id (email_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(45) NOT NULL,
  description longtext,
  PRIMARY KEY (role_id),
  UNIQUE KEY role_name (role_name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,  
  CONSTRAINT FKF6CCD9C6432D04C1 FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT FKF6CCD9C6E857C8A1 FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE tags (
  tag_id int(11) NOT NULL AUTO_INCREMENT,
  label varchar(45) NOT NULL,
  value varchar(45) NOT NULL,
  description varchar(256) DEFAULT NULL,
  PRIMARY KEY (tag_id),
  UNIQUE KEY label (label)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE posts (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  description longtext,
  posted_by int(11) NOT NULL,
  created_on datetime DEFAULT NULL,
  PRIMARY KEY (post_id),
  CONSTRAINT FK65E7BD368CCD1E9 FOREIGN KEY (posted_by) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE posts_tags (
  post_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  CONSTRAINT FK95F5DD05D9C91C81 FOREIGN KEY (post_id) REFERENCES posts (post_id),
  CONSTRAINT FK95F5DD05F448AFD3 FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE comments (
  comment_id int(11) NOT NULL AUTO_INCREMENT,
  post_id int(11) NOT NULL,
  message longtext NOT NULL,
  posted_by int(11) NOT NULL,
  created_on datetime NOT NULL,
  PRIMARY KEY (comment_id),
  CONSTRAINT FKDC17DDF468CCD1E9 FOREIGN KEY (posted_by) REFERENCES users (user_id),
  CONSTRAINT FKDC17DDF4D9C91C81 FOREIGN KEY (post_id) REFERENCES posts (post_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE ratings (
  post_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  rating int(11) NOT NULL,
  PRIMARY KEY (post_id,user_id),
  CONSTRAINT FK3AA08276E857C8A1 FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT FK3AA08276D9C91C81 FOREIGN KEY (post_id) REFERENCES posts (post_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into roles(role_id, role_name, description)
values
(1,'Administrator','Administrator'),
(2,'Super Admin','Super Administrator'),
(3,'HR Executive','HR Executive'),
(4,'Finance Dept Mngr','Finance Dept Mngr');

insert  into users(user_id,email_id,password,firstName,lastName,gender,phone,dob,disabled,bio) 
values 
(1,'admin@gmail.com','admin','Mr','Administrator','Male',NULL,NULL,NULL,'I am the THE admin'),
(2,'test@gmail.com','test','Mr','Test','Female',NULL,NULL,1,'I am a tester'),
(3,'guest@gmail.com','secret','Mr','Guest','Female','922221222545','2013-04-29 00:00:00',0,'Hey, this is Mr Guest');

insert  into tags(tag_id,label,value, description)
values 
(1,'JavaSE','java-se','Java Programming Language'),
(2,'JavaEE','java-ee','Java Enterproze Edition'),
(3,'Spring','spring','Spring Framework'),
(4,'SpringMVC','springmvc','SpringMVC framework'),
(5,'Hibernate','hibernate','Hibernate ORM Framework'),
(6,'Struts','struts','Struts Framework'),
(7,'JSF','jsf','JSF Framework'),
(8,'PrimeFaces','primefaces','PrimeFaces UI Component library for JSF'),
(9,'jQuery','jquery','jQuery: JavaScript framework'),
(10,'Perl','perl','Perl Programming Language'),
(11,'Python','python','Python Programming Language');


insert  into posts(post_id,created_on,description,title,posted_by) 
values 
(1,'2013-01-21 00:00:00','PrimeFaces Team is pleased to announce the 3.5.4 Elite release featuring 20+ filed improvements. So far including the previous 3.5.x Elite releases there have been more than 110 improvements over 3.5 release. 3.5.5 focuses on defect fixes and performance improvements.','PrimeFaces Elite 3.5.5 Released',1),
(2,'2013-01-21 00:00:00','PrimeFaces.NET is the port of PrimeFaces for JSF as an open source rich control suite for ASP.NET WebForms. 0.1 version is the initial release with 13 controls including Accordion, TabView, Spinner, Slider, Panel, Fieldset and more.','PrimeFaces for ASP.NET 0.1 Released',1),
(3,'2013-01-21 00:00:00','Community powered PrimeFaces Extensions project has reached 0.7 release with various new features, improvements to existing features and defect fixes.','PrimeFaces Extensions 0.7 Released',1),
(4,'2013-01-21 00:00:00','PrimeFaces 4.0 codename SENTINEL will introduce dragdrop based manipulation support for Tree component.','DragDrop Support for Tree',1),
(5,'2013-01-21 00:00:00','PrimeUI is back with a brand new release and closer than ever to 1.0 Final. This 0.9 release brings 7 new widgets from PrimeFaces making 27 widgets in total.','PrimeUI 0.9 Released',1),
(6,'2013-01-21 00:00:00','PrimeTek is pleased to announce the new 0.9.4 release for PrimeFaces Mobile. This version brings new mobile widgets, bug fixes and performance improvements.','PrimeFaces Mobile 0.9.4 Released',1),
(7,'2013-01-21 00:00:00','March/April 2013 issue of JavaMagazine is out and Kito D. Mann from Virtua Inc. has written a great article on Interportlet Communication with PrimeFaces Push powered by Atmosphere on Liferay.','Responsive Interportlet Communication with Atmosphere and PrimeFaces',1),
(8,'2013-01-21 00:00:00','REST applications and web services are a great way to connect applications together. REST is a design principle that imposes no constraints on the client except basic HTTP support, which all platforms provide. Designing REST services, however, is still as much art as it is science, as standards are emerging. Join Spring Developer Advocate Josh Long as he introduces some of the ins-and-outs of REST API design with Spring, building on Spring MVC, Spring HATEOAS and answers some commonly- asked questions like how to secure REST-ful services, and how to tailor payload serialization to your specific use cases.','Building REST-ful services with Spring',1),
(9,'2013-01-21 00:00:00','We are pleased to announce that the second milestone for Spring Integration 3.0.0 is now available. 64 issues are resolved, including many improvements and new features;','Spring Integration 3.0 Milestone 2 is Now Available',1),
(10,'2013-01-21 00:00:00','As you may have seen, the first milestone of Spring Framework 4.0 was already announced and with it we have released early WebSocket support.','Spring Framework 4.0 M1: WebSocket Support',1),
(11,'2013-01-21 00:00:00','We are pleased to announce that, after a long period of internal incubation, we are releasing a foundational framework for asynchronous applications on the JVM which we are calling Reactor. ','Reactor: a foundation for asynchronous applications on the JVM',1),
(12,'2013-01-21 00:00:00','Spring Data MongoDB provides a feature rich library for writing MongoDB applications in Java. It builds upon the Spring Framework and as such promotes a POJO programming model with a strong emphasis on productivity.','THE SPRING DATA MONGODB PROJECT',1),
(13,'2013-01-21 00:00:00','Few companies have been quite at the forefront of implementing Spring Integration (Batch & Data etc.) as Incept5, this years VMWare EMEA cloud partner.','SPRING INTEGRATION IN THE WILD',1),
(14,'2013-01-21 00:00:00','The continuous evolution of both the Spring Framework and the Java EE platform presents us with new challenges and opportunities for collaboration. Several recent EE services are very commonly used with Spring, e.g. Servlet 3.0, JPA 2.0 and Bean Validation. This session presents an up-to-date analysis: How do recent Spring versions (3.1/3.2) integrate with Java EE 6? How is this going to be affected by Java EE 7 in a years time?','JAVA EE SERVICES FOR SPRING APPLICATIONS',1),
(15,'2013-01-21 00:00:00','EclipseLink 2.5 has been released and is available for download. http://www.eclipse.org/eclipselink/releases/2.5.php','EclipseLink 2.5 Release Available for Download',1),
(16,'2013-01-21 00:00:00','Did you ever imagine that someday it would be possible to code in the cloud? Create an app, test and debug it and deploy to a production PaaS, entirely in the cloud? Well, the good old desktop days are gone.','3 Online IDEs That Rock',1);


insert  into posts_tags(post_id,tag_id) 
values 
(1,3),
(1,2);



