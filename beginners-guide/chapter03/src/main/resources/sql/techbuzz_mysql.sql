
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
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  firstName varchar(255) DEFAULT NULL,
  lastName varchar(255) DEFAULT NULL,
  email_id varchar(255) NOT NULL,
  phone varchar(255) DEFAULT NULL,
  dob datetime DEFAULT NULL,
  disabled tinyint(1) NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY email_id (email_id),
  UNIQUE KEY username (username)
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


insert  into users(user_id,username,password,firstName,lastName,email_id,phone,dob,disabled) 
values 
(1,'admin','admin','Mr','Administrator','admin@gmail.com',NULL,NULL,NULL),
(2,'test','test','Mr','Test','test@gmail.com',NULL,NULL,1),
(3,'guest','secret','Mr','Guest','guest@gmail.com','922221222545','2013-04-29 00:00:00',0);

insert  into tags(tag_id,label,value)
values 
(1,'JavaSE','java-se'),
(2,'JavaEE','java-ee'),
(3,'Spring','spring'),
(4,'SpringMVC','springmvc'),
(5,'Hibernate','hibernate'),
(6,'Struts','struts');


insert  into posts(post_id,created_on,description,title,posted_by) 
values 
(1,'2013-01-21 00:00:00','It turns out that iTunes (at least 11.0.2 build 26) doesn’t actually implement Apple’s own specification properly, in that it can’t handle media segment URIs relative to the URI of the m3u8 playlist.','Apple Can\'t Obey Its Own Specifications',1),
(2,'2013-01-21 00:00:00','Everyone is talking about the Yahoo! memo ending work from home for employees. I am reminded of an article on Rands in Repose about telecommuting.','The Work From Home Question',1),
(3,'2013-01-21 00:00:00','I must confess that despite all benefits of defensive programming, I usually limit myself to not expose mutable attribute to the outside world. Why is that?','Design by Contract and Bean Validation',1),
(4,'2013-01-21 00:00:00','I think that codes of conduct should be positive definitions of expected behavior rather than a series of prohibitions. Here\'s the code of conduct I\'ll use for my next conference.','Code of Conduct for Communities',1),
(5,'2013-01-21 00:00:00','Brian and Steve Damadeo have a lively conversation about doing mobile app development. They talk through the steps that Steve’s team have taken in the last few years to develop solutions at Festo and come up with a set of lessons to be used when going through the process.','The Mobilecast: App Development & Lessons Learned at Festo',1),
(6,'2013-01-21 00:00:00','The history of computer systems is also the history of bugs, including epic, disastrous bugs that have caused millions of $ in damage and destruction and even death, as well as many other less spectacular but expensive system and project failures.','Architecture-Breaking Bugs – when a Dreamliner Becomes a Nightmare',1),
(7,'2013-01-21 00:00:00','It\'s worth noting off the bat that Distributism arose as a critique both of Capitalism and Communism and represents something with some of the ideals of both sides, but altogether different in character than either.','A Distributist View on Software Freedom',1),
(8,'2013-01-21 00:00:00','IntelliJ IDEA keeps amazing me. Last week I learned the code formatter of IntelliJ IDEA 12 supports Spock specific where: block formatting. Spock has great a great feature called data tables.','IntelliJ IDEA Knows How to Format Spock where: Blocks',1),
(9,'2013-01-21 00:00:00','This is the problem everybody knows and I don’t talk about Syntax here. Instead, I want to see what the .class file look like when .java file is compiled, and how JVM load the class and invoke the main method','What Can We Learn From a Java HelloWorld Program?',1),
(10,'2013-01-21 00:00:00','When software is revised for a new framework or operating system or database or when an algorithm is converted to a new language, then we\'re \"converting\" (or \"migrating\") software. We\'re preserving code, and preserving the knowledge encoded.','Legacy Code Preservation',1),
(11,'2013-01-21 00:00:00','Yo probably format your code often by pressing Ctrl+Shift+F or right clicking Source -> Format. This function is also provide in JDT, so you can also format your Java code in code.','How to Format Java Code Using Eclipse JDT?',1);


insert  into posts_tags(post_id,tag_id) 
values 
(1,3),
(1,2);



