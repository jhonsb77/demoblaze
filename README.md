# Proyecto automatizacion portal demoblaze y APIS petStore

<p align="center">
  <a href="https://serenity-bdd.github.io/theserenitybook/latest/index.html"> 
  <img src="https://serenity-bdd.info/wp-content/uploads/elementor/thumbs/serenity-bdd-pac9onzlqv9ebi90cpg4zsqnp28x4trd1adftgkwbq.png" title="Serenity"> 
  </a>
  <a href="https://cucumber.io/"> 
  <img src="https://ichi.pro/assets/images/max/724/1*KalezkxhSguQlz-LGv6F4A.png" title="Cucumber BDD"> 
  </a>
  <a href="https://www.selenium.dev/"> 
  <img src="https://selenium-python.readthedocs.io/_static/logo.png" title="Selenium" > 
  </a>
  <a href="https://gradle.org/"> 
  <img src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228" title="Gradle" > 
  </a> 
</p>

Pre-requisitos
- Mozilla firefox version 117.0 (ultima actualizacion a la fecha)
- JDK version 1.8.0
- Gradle 
- Entorno de desarrollo IntelliJ IDEA
- Git

nota: debido a que el driver de chrome a la fecha solo esta disponible para versiones anteriores a la 114, la ejecucion solo funciona para el navegador mozilla firefox
![img_1.png](img_1.png)
repositorio de los drivers para chrome https://chromedriver.chromium.org/downloads 

Estructura del proyecto
- features: en esta carpeta se encuentra redactado los casos de prueba en lenguaje gherkin que se plantearon para el portal demoblaze (CarritoCompra.feature) y la tienda de mascotas (PetStore.feature)
- stepsdefinitons: en esta carpeta se encuentra el paso a paso de los features que se utiliza para asociarlos a los archivos feature
- page: se encuentra toda la logica de programacion utilizada por los casos de prueba
- runner: clase la cual se utiliza para ejecutar los casos de prueba
- utils: configuracion del driver correspondiente al navegador donde se ejecutaran las pruebas

Instrucciones de ejecucion
1. Clonar el proyecto del repositorio https://github.com/jhonsb77/demoblaze.git mediante el comando git clone en la carpeta deseada de su equipo
2. En el etorno de desarrrollo, seleccionar la opcion "File" y posteriormente la opcion "Open". Alli seleccionara el proyecto guardado en la ruta del paso anterior
3. Esperar a que el proyecto se configure y descargue las dependecias, si esto no se realiza, en el archivo "build.gradle" seleccionar la opcion "reload all gradle projects"
![img_2.png](img_2.png)
4. Seleccionar el archivo runner especifico para cada feature, dar click derecho y seleccionar la opcion "Run"
5. Al finalizar la ejecucion los reportes de la misma se podran visualizar en el archivo index.html ubicado en la ruta: demoblaze\target\site\serenity



