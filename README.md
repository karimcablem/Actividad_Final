

# Actividad_Final
##### Tabla de Contenidos

[Descripción del proyecto](#descripción-del-proyecto)</br>
[Problema Identificado](#problema-identificado)</br>
[Solución](#solución)</br>
[Diagrama de solución](#diagrama-de-solución)</br>
[Arquitectura](#arquitectura)</br>
[Diagrama ER](#diagrama-er)</br>

## Descripción del proyecto
Consolidación de Front end de incidencias y problemas técnicos, control de fixes, control de releases y fechas de despliegue.

## Problema Identificado
•	Actualmente se lleva un control de incidencias mediante una herramienta auditada por Control Interno llamada Service Manager, en la cual se cargan los reportes asociados a incidencias por disponibilidad y errores de las aplicaciones dentro del departamento de Sistemas en Izzi.</br>
•	Por otro lado, se genera una tabla en Excel con los fixes que arreglan problemas o nuevas funcionalidades.</br>
•	Para realizar el seguimiento de Incidencia vs Fix, se tiene que llevar un Excel en el cual se tengan los puntos, comentarios y fechas que correspondan con el fix o con el incidente.</br>
•	Se tiene que llevar un control externo de fechas de liberación, plataformas asociadas y el control de versiones.</br>
•	Cada usuario lleva un Excel con sus propios comentarios y cuando es necesario saber el estado actual se tiene que realizar una junta para que todos puedan actualizar sus puntos.</br>
•	No se cuenta con un catalogo de Releases o subreleases que indiquen las fechas de liberación, por lo cual hay que recurrir a los correos o elaborar una tabla en Excel propia para llevar dicho control.</br>
•	No se cuenta con una plataforma para evaluar la efectividad del reléase y poder calcular el índice de efectividad de acuerdo a las incidencias generadas post reléase o garantías generadas por un fix fallido.</br>

## Solución
•	La solución propuesta es consolidar toda la información en una base de datos relacional, en la cual se pueda tener acceso a las incidencias generadas y por otro lado el detalle de los fixes y que estos estén asociados a los releases generados ya sea con fecha o aún pendiente de ella.</br>
•	Se busca evitar retrabajo de información por diferentes áreas, ya que los usuarios podrán hacer sus anotaciones de seguimiento y podrán ser almacenadas por fecha y responsable.</br>
•	 La carga y consulta seria mediante un Front End que cuente con las opciones de carga de catálogos y consulta de incidencias.</br>

## Diagrama de solución
![image](https://user-images.githubusercontent.com/46138134/207199283-c0fdab32-6c90-4dd4-8627-78c4eb7deb5c.png)

## Arquitectura
![image](https://user-images.githubusercontent.com/46138134/207199788-ab0d320c-fc0a-4fac-ac66-d71fa8651dda.png)

## Diagrama ER
![image](https://user-images.githubusercontent.com/46138134/207199838-72a93d89-57cf-461e-8ad8-c091df45d210.png)

