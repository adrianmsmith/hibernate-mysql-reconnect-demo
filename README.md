Demonstration of reconnecting to MySQL automatically from Hibernate.

See https://www.databasesandlife.com/automatic-reconnect-from-hibernate-to-mysql/ for instructions.

Branches:

* The "master" branch demonstrates the problem
* The "fix" branch demonstrates the fix.

To run the code:

1. Install [Vagrant](https://www.vagrantup.com/) and [VirtualBox](https://www.virtualbox.org/) on your machine, then run `vagrant up`.
1. In one window, execute the Maven command that is printed at the end of `vagrant up`. This will execute in an infinite loop and attempt to execute statements.
1. In another window, restart MySQL, and see the error (in the "master" branch) or it work (in the "fix" branch).