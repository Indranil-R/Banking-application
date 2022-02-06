Begin
   execute immediate 'Drop table account';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

create table account(accno number(12) primary key,name varchar2(255)  not null,password varchar2(255)  not null,email_id varchar2(255)  not null ,mobile_number number(10) unique not null,amount number(8,2)  not null,address varchar2(255)  not null);
 

 
 