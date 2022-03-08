# SYSC4806-Project - Mini-SurveyMonkey

## Project Description:
Surveyor can create a survey with a list of Questions. Questions can be open-ended (text), asking for a number within a range, or asking to choose among many options. Users fill out a survey that is a form generated based on the type of questions in the survey. Surveyor can close the survey whenever they want (thus not letting in new users to fill out the survey), and at that point a survey result is generated, compiling the answers: for open-ended questions, the answers are just listed as-is, for number questions a histogram of the answers is generated, for choice questions a pie chart is generated

## Team Members:
- Adi El Sammak
- Astrid MacKinnon
- Danniel Innes
- Erik Iuhas
- Marianne Brissette

## Deliverable 1:
For this deliverable, we have built an application with one operational use case. The application is hosted on **TravisCI** and deployed on **Heroku**. To develop the application, we are using the framework Spring Boot on the back end and React Static for the front end. Note that the code for the front end is here: https://github.com/Daniel-W-Innes/SYSC4806-Project-Frontend 

### Model
In this application, we consider that to create surveys, a user must have an account. When the user creates an account, the user becomes a *Surveyor* and can create *Survey* objects. To fill surveys, users do not need accounts. Surveys are composed of a list of *Question* objects. The most basic type of questions is long answer question. These are modeled with the *Question* class. *MultipleChoiceQuestion* are questions where the user must pick an option from a list. These can also be used for True or False questions. *NumberQuestion* are questions where the user is asked to pick a number in a range. When users fill surveys, we create *Answer* objects to record their answers. Answers are associated with one particular *Question* and *Survey*. *TextAnswer* are used for long answer questions and multiple choice questions. *NumberAnswer* are used for number questions. Note that one *Question* has as many *Answer* associated to it as the number of people who answer the question.

![ModelUML](/documentation/ModelClassUML_v1.PNG)

### Database
The database structure is very similar to the structure of the model classes. We are using a PostgreSQL database hosted on Heroku. One-to-many relationships are modelled with foreign keys and inheritance is modelled with joined tables.

![DatabaseSchema](/documentation/DatabaseSchema_v1.PNG)


### Operational Use Case
