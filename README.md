# Hair-Salon

This readme contains details of this website and how to run it on your local machine.

## Whats It About?

This is a website that links Salon clients and stylists. Users are able to find out about various hair stylists out there and add themselves as stylists, so as to be hired to work as stylists. Also for constant users, they can add themselves as clients for various stylists to receive news of new and good looking hair styles.

## Creators

 Bry Onyoni.

## Prerequisites

You will need the following things properly installed on your computer:

* [Git](https://git-scm.com/)
* [Gradle](https://gradle.org/install)
* [Java JDK and JRE](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html)
* [Postgresql for windows users](https://curtello.github.io/devblog/PostgreSQL-Installations/)
* [Postgresql for linux users](https://www.postgresql.org/download/linux/)

## Installation
 (remember all this is being done in your command terminal, or PowerShell for windows users)
* `git clone <https://github.com/bryonyoni/Super-Hero-Caffe.git>` clone this repository.
* Then open two separate terminals and run `psql -U postgres postgres` (or `$ postgres ` then `$ psql` for linux users.)
* Then put in your username and password and afterwards it should show something like this`postgres=#`.
* You can then set up your remote database using the following:
`CREATE DATABASE hair-salon;`
`\c hair-salon;`
`CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);`
`CREATE TABLE clients (id serial PRIMARY KEY, description varchar, stylistsyId int);`


**NOTE:** When creating the database,if you have already created a test database, it's important to delete the old test database when you create or alter a new one.

* Then run `gradle build`
* Then in the root folder run `gradle run`.
* Once it shows something like this: `>Building 75% > :run` go to your browser and type in this link `http://localhost:4567`.

## Further Reading / Useful Links

* [Javase issues](http://www.oracle.com/technetwork/java/javase/8-known-issues-2157115.html)
* [Spark Documentation](http://sparkjava.com/documentation#getting-started)

## Contributing

I welcome pull requests. If there are any issues concerning the webpage, raise them and I'll have them fixed in no time!

## License

This project is released under the [MIT License](./LICENSE.md)
