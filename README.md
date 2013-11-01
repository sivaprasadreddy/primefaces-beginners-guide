## PrimeFaces Beginner's Guide Book Source Code

### K. Siva Prasad Reddy


#### Chapter 1 : Introduction to PrimeFaces
In this chapter we will learn about:

* Installing and configuring PrimeFaces	
* Creating Simple Forms using PrimeFaces	
* Performing Form Validations	
* Partial Form Processing
	
#### Chapter 2 : Introducing Sample Application TechBuzz
In this chapter we will learn about:

* Sample application "TechBuzz"
* Functional Requirements
* Sample UI Screenshots
	
#### Chapter 3 : Using PrimeFaces Common Utility Components
In this chapter we will learn about:

* Dialog, Tooltip
* Growl, Messages, BlockUI
* Button, CommandButton, CommandLink
* Working with PrimeFaces Selectors and Events

#### Chapter 4 : Introducing Primefaces Client Side Validations framework

In this chapter we will learn about:

* Configuring and using Client Side Validation (CSV) Framework
* Triggering client side validations based on events
* Supporting I18N for validation messages
* Extending CSV framework with custom JSF Converters and Validators
* Using CSV framework with Bean Validation API
* Extending CSV framework with custom Bean Validation annotations
	
#### Chapter 5 : Introducing Text Input Components
In this chapter we will learn about:

* InputText, InputTextarea, Password
* InputMask, Editor
* AutoComplete
	
#### Chapter 6 : Working with Selection Input Components
In this chapter we will learn about:

* BoolCheckbox, SelectManyCheckbox
* SelectOneRadio 
* SelectOneMenu, SelectOneListbox
* SelectManyMenu
* PickList
	
#### Chapter 7 : Introducing Advanced Input Components
In this chapter we will learn about:

* Calendar
* File Upload
* File Download
* Rating, Spinner, Slider
* Captcha
	
#### Chapter 8 : Working with Data Components
In this chapter we will learn about:

* DataList (Unordered List, Ordered List, Pagination)
* DataTable (Simple, Header Footer, Pagination, Sorting, Filtering, Row Selection, Lazy Loading, Inline Row/Cell Editing)
* DataExporter

#### Chapter 9 - Introducing Advanced Data Visualization Components
In this chapter we will learn about:

* Carousel
* TagCloud
* Tree
* TreeTable
* Schedule
	
#### Chapter 10 - Working with Layout Components
In this chapter we will learn about:

* Panel components - Panel, PanelGrid, ScrollPanel
* Component layout styles -  Accordion, TabView, Wizard
* Creating Complex Layouts
	
#### Chapter 11 - Introducing Navigation Components
In this chapter we will learn about:
	
* Menu
* MenuButton
* TieredMenu
* SlideMenu
* Menubar
* MegaMenu
* TabMenu
* PanelMenu
* ContextMenu
* BreadCrumb
	
##### Chapter 12 - Drawing Charts
In this chapter we will learn about:
	
* Line Chart 
* Area Chart
* Bar Chart
* Pie Chart
* Donut Chart
* Exporting Charts as Images
* Creating charts using JFreeChart API
* Handling itemSelect Ajax event

#### Chapter 13 - Using PrimeFaces Themes
In this chapter we will learn about:
	
* Using built-in Themes
* ThemeSwitcher
* Custom Themes
	
Installing seablue theme in local maven repository:

1. Rename seablue-1.10.3.zip to seablue-1.10.3.jar
2. Install seablue-1.10.3.jar into local maven repo using the following command

	mvn install:install-file -Dfile=c:\dev\seablue-1.10.3.jar -DgroupId=org.primefaces.themes -DartifactId=seablue -Dversion=1.10.3 -Dpackaging=jar
		
Note: If you want to use different groupId and artifactId you can chane using -DgroupId and -DartifactId options. 
And don't forget to change the groupId and artifactId in pom.xml accordingly.
	
