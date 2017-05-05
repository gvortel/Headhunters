# HeadHunters
Application that automates some of the processes that take place in the context of running a Job-Placement company.
(includes also Database and GUI ) 
Admin / User Mode

Optimization:
- Query State changes to Invalid if Employee client gets hired at a job so that there will not be unnecessary contacts made by the Head Hunters Company to any Employer client for every newpostedjob matched with that query.
- Job State changes for the same reason
- Security check in case more than one clients declare the same card number
- If respond is out of time then the state of the Job Index will not change from Failed
- Security check for responses. Any Employer who wants to accept a match index , should have the authority to do it and that match index must exist.
- Password at login screen

RD Model
![alt text](https://github.com/gvortel/Headhunters/blob/master/tables.png)

