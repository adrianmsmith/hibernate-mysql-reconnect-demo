# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.hostname = "hibernate-reconnect-demo"
  config.vm.box = "debian/contrib-buster64"
  
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "2000"
  end

  # runs as root within the VM
  config.vm.provision "shell", inline: %q{
  
    set -e  # stop on error

    echo --- General OS installation
    # timedatectl set-timezone "Europe/Vienna"
    apt-get --allow-releaseinfo-change update
    apt-get update
    DEBIAN_FRONTEND=noninteractive apt-get upgrade -q -y    # grub upgrade warnings mess with the terminal
    apt-get -q -y install vim ntp unattended-upgrades 

    echo --- Install Java 11 \(OpenJDK\)
    apt-get -qy install openjdk-11-jdk maven
    
    echo --- Install MySQL
    apt-get -qy install mariadb-client mariadb-server
    echo 'CREATE USER vagrant IDENTIFIED BY "vagrant"' | mysql
    echo 'CREATE DATABASE test' | mysql
    echo 'CREATE TABLE my_thing (string_value VARCHAR(100))' | mysql test
    echo 'GRANT ALL privileges ON test.* TO "vagrant"@"%"' | mysql
  }

  config.vm.provision "shell", run: "always", inline: %q{
  
    set -e  # stop on error
    
    echo ''
    echo '-----------------------------------------------------------------'
    echo 'After "vagrant ssh":'
    echo '   mysql -uvagrant -pvagrant test'
    echo '   mvn -f /vagrant/pom.xml package exec:java'
    echo '   sudo /etc/init.d/mysql restart'
    echo '-----------------------------------------------------------------'
    echo ''
  }
end
