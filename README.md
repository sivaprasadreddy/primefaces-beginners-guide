primefaces-beginners-guide
==========================

PrimeFaces Beginner's Guide Book Source Code


Chapter 1 : Introduction to PrimeFaces
---------------------------------------
In this chapter we will learn about:
	1) Installing and configuring PrimeFaces
	2) Creating Simple Forms using PrimeFaces
	3) Performing Form Validations
	4) Partial Form Processing

Chapter 2 : Creating a Sample Application
-----------------------------------------
In this chapter we will learn about:
	1) Sample application "TechBuzz"
	2) Functional Requirements
	3) Sample UI Screenshots

Chapter 3 : PrimeFaces Common Utility Components
------------------------------------------------
In this chapter we will learn about:
	1) Dialog, Tooltip
	2) Growl, Messages, BlockUI
	3) Button, CommandButton, CommandLink
	4) Working with PrimeFaces Selectors and Events

Chapter 4 : Introducing Primefaces Client Side Validations framework
---------------------------------------------------------------------
In this chapter we will learn about:
	1)Configuring and using Client Side Validation (CSV) Framework
	2) Triggering client side validations based on events
	3) Supporting I18N for validation messages
	4) Extending CSV framework with custom JSF Converters and Validators
	5) Using CSV framework with Bean Validation API
	6) Extending CSV framework with custom Bean Validation annotations

Chapter 5 : Text Input Components
---------------------------------
In this chapter we will learn about:
	1) InputText, InputTextarea, Password
	2) InputMask, Editor
	3) AutoComplete

Chapter 6 : Selection Input Components
--------------------------------------
In this chapter we will learn about:
	1) BoolCheckbox, SelectManyCheckbox
	2) SelectOneRadio 
	3) SelectOneMenu, SelectOneListbox
	4) SelectManyMenu
	5) PickList

Chapter 7 : Advanced Input Components
--------------------------------------
In this chapter we will learn about:
	1) Calendar
	2) File Upload
	3) File Download
	4) Rating, Spinner, Slider
	5) Captcha

Chapter 8 : Data Components
----------------------------
In this chapter we will learn about:
	1. DataList
		a) Unordered List
		b) Ordered List
		c) Pagination

	2. DataTable
		a) Simple
		b) Header Footer
		c) Pagination
		d) Sorting
		e) Filtering
		f) Row Selection
		g) Lazy Loading
		h) Inline Row/Cell Editing

	3. DataExporter

Chapter 9 - Advanced Data Visualization Components
---------------------------------------------------
In this chapter we will learn about:
	1. Carousel
	2. TagCloud
	3. Tree
	4. TreeTable
	5. Schedule
	
Chapter 10 - Layout Components
-------------------------------
In this chapter we will learn about:
	1. Panel components - Panel, PanelGrid, ScrollPanel
	2. Component layout styles -  Accordion, TabView, Wizard
	3. Creating Complex Layouts
	
Chapter 11 - Navigation Components
------------------------------------
In this chapter we will learn about:
	
	1. Menu
	2. MenuButton
	3. TieredMenu
	4. SlideMenu
	5. Menubar
	6. MegaMenu
	7. TabMenu
	8. PanelMenu
	9. ContextMenu
	10. BreadCrumb
	
Chapter 12 - Drawing Charts
-----------------------------
In this chapter we will learn about:
	
	1. Line Chart 
	2. Area Chart
	3. Bar Chart
	4. Pie Chart
	5. Donut Chart
	6. Exporting Charts as Images
	7. Creating charts using JFreeChart API
	8. Handling itemSelect Ajax event

Chapter 13 - Theming
----------------------
In this chapter we will learn about:
	
	1. Using built-in Themes
	2. ThemeSwitcher
	3. Custom Themes
	
	Installing seablue theme in local maven repository:
	1. Rename seablue-1.10.3.zip to seablue-1.10.3.jar
	2. Install seablue-1.10.3.jar into local maven repo using the following command	
		mvn install:install-file -Dfile=c:\dev\seablue-1.10.3.jar -DgroupId=org.primefaces.themes -DartifactId=seablue -Dversion=1.10.3 -Dpackaging=jar
		
	Note: If you want to use different groupId and artifactId you can chane using -DgroupId and -DartifactId options. And don't forget to change the groupId and artifactId in pom.xml accordingly.
	
