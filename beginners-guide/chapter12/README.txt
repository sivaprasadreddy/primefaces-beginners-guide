PrimeFaces Beginners Guide : Chapter12 - Theming
---------------------------------------------------------
In this chapter we will learn about:
	
	1. Using built-in Themes
	2. ThemeSwitcher
	3. Custom Themes
	
Installing seablue theme in local maven repository:
1. Rename seablue-1.10.3.zip to seablue-1.10.3.jar
2. Install seablue-1.10.3.jar into local maven repo using the following command	
	mvn install:install-file -Dfile=c:\dev\seablue-1.10.3.jar -DgroupId=org.primefaces.themes -DartifactId=seablue -Dversion=1.10.3 -Dpackaging=jar
	
Note: If you want to use different groupId and artifactId you can chane using -DgroupId and -DartifactId options. And don't forget to change the groupId and artifactId in pom.xml accordingly.
	