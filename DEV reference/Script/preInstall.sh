# OpenCPS is the open source Core Public Services software
# Copyright (C) 2016-present OpenCPS community

# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# any later version.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU Affero General Public License for more details.
# You should have received a copy of the GNU Affero General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.

export oraclejdk=$(echo 'http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm')
export oraclejdkbak=$(echo 'https://www.dropbox.com/s/dehjmpfpo29x4s1/jdk-7u79-linux-x64.rpm')
export ant=$(echo 'https://www.apache.org/dist/ant/binaries/apache-ant-1.9.7-bin.tar.gz')
progressfilt ()
{
    local flag=false c count cr=$'\r' nl=$'\n'
    while IFS='' read -d '' -rn 1 c
    do
        if $flag
        then
            printf '%c' "$c"
        else
            if [[ $c != $cr && $c != $nl ]]
            then
                count=0
            else
                ((count++))
                if ((count > 1))
                then
                    flag=true
                fi
            fi
        fi
    done
}

echo ""
echo "================================="
echo "||  Install Required Packages  ||" 
echo "================================="
echo 'nameserver 8.8.8.8' >> /etc/resolv.conf	
pkg1=$(rpm -qa| grep wget)
echo -n 'Checking wget package...'
	if [[ "$pkg1" == *"wget"*  ]];then
	echo ' OK!'
else
	echo ' not found'
	echo -n '====> Installing wget...'; yum -y install wget >> /dev/null 2>&1;
	pkg1=$(rpm -qa| grep wget)
	if [[ "$pkg1" == *"wget"*  ]];then
		echo ' Completed'
	else
		echo ''
		echo 'Something wrong with network connection, please resolv the network problem or try again late'
		exit 1;
	fi
fi

echo ''
pkg2=$(rpm -qa| grep unzip)
echo -n 'Checking unzip package...'
if [[ "$pkg2" == *"unzip"*  ]];then
	echo ' OK!'
else
	echo ' not found'
	echo -n '====> Installing unzip...'; yum -y install unzip >> /dev/null 2>&1;
	pkg2=$(rpm -qa| grep unzip)
	if [[ "$pkg2" == *"unzip"*  ]];then
		echo ' Completed'
	else
		echo ''
		echo 'Something wrong with network connection, please resolv the network problem or try again late'
		exit 1;
	fi
fi

echo ''
pkg3=$(rpm -qa| grep git)
echo -n 'Checking git package...'
if [[ "$pkg3" == *"git-"*  ]];then
        echo ' OK!'
else
	echo ' not found'
	echo -n '====> Installing git...'; yum -y install git >> /dev/null 2>&1;
	pkg3=$(rpm -qa| grep git)
	if [[ "$pkg3" == *"git"*  ]];then
		echo ' Completed'
	else
		echo ''
		echo 'Something wrong with network connection, please resolv the network problem or try again late'
		exit 1;
	fi
fi
echo ""
echo "** DONE! **"

echo ""
echo "============================================="
echo "||  Install Oracle JDK 7u79 and Ant 1.9.7  ||" 
echo "============================================="
pkg4=$(rpm -qa| grep jdk)
echo -n 'Checking Oracle JDK package...'
if [[ "$pkg4" == *"jdk-1.7.0_79"*  ]];then
        echo ' OK!'
else
	echo ' not found'
	echo -n '====> Installing Oracle JDK 7u79...'
	mkdir /usr/java >> /dev/null 2>&1
	cd /usr/java >> /dev/null 2>&1
	wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" --progress=bar:force $oraclejdk 2>&1 | progressfilt
	FILE1=$(echo 'jdk-7u79-linux-x64.rpm')
	while [ ! -f $FILE1 ]
		do
		echo 'Download process failed. Trying re-download, please wait...'
		wget --no-cookies --no-check-certificate --progress=bar:force $oraclejdkbak 2>&1 | progressfilt
	done

	export md5check=$(md5sum jdk-7u79-linux-x64.rpm | awk '{print $1}')
	export md5basejdk=$(echo '8486da4cdc4123f5c4f080d279f07712')
	while [ "$md5check" != "$md5basejdk" ]
	do
		echo 'Checking MD5... Failed!'
		echo 'This file is corrupted. Trying download another file, Please wait...'
		rm -rf /usr/java/jdk-7u79-linux-x64.rpm
		wget --no-cookies --no-check-certificate --progress=bar:force $oraclejdkbak 2>&1 | progressfilt
		export md5check=$(md5sum jdk-7u79-linux-x64.rpm | awk '{print $1}')
	done

	echo 'Checking MD5... OK!'
	rpm -Uvh jdk-7u79-linux-x64.rpm 
	rm -rf jdk-7u79-linux-x64.rpm
	echo 'Oracle JDK 7u79 has been installed!'
fi

echo ''
echo '---'
pkg5=$(ant -version)
echo -n 'Checking Ant package...'
if [[ "$pkg5" == *"Apache Ant(TM) version 1.9.7"*  ]];then
        echo ' OK!'
else
	echo '- Downloading Ant 1.9.7'
	cd /usr/java
	wget --progress=bar:force $ant 2>&1 | progressfilt
	FILE2=$(echo 'apache-ant-1.9.7-bin.tar.gz')
	while [ ! -f $FILE2 ]
		do
		echo 'Download process failed. Trying re-download, please wait...'
		wget --progress=bar:force $ant 2>&1 | progressfilt
	done

	export md5check=$(md5sum apache-ant-1.9.7-bin.tar.gz | awk '{print $1}')
	export md5baseant=$(wget http://www-us.apache.org/dist/ant/binaries/apache-ant-1.9.7-bin.tar.gz.md5 -q -O -)
	while [ "$md5check" != "$md5baseant" ]
		do
		echo 'Checking MD5... Failed!'
		echo 'This file is corrupted. Trying download another file, Please wait...'
		rm -rf /usr/java/apache-ant-1.9.7-bin.tar.gz
		wget --progress=bar:force $ant 2>&1 | progressfilt
		export md5check=$(md5sum apache-ant-1.9.7-bin.tar.gz | awk '{print $1}')
	done

	echo 'Checking MD5...OK!'
	echo 'Ant 1.9.7 has been installed!'
fi

tar zxvf apache-ant-*.tar.gz >> /dev/null 2>&1
rm -rf apache-ant-*.tar.gz

export ANT_HOME=/java/apache-ant-1.9.7
echo 'export ANT_HOME=/usr/java/apache-ant-1.9.7' >> ~/.bash_profile

export PATH=$PATH:$ANT_HOME/bin
echo 'export PATH=$PATH:$ANT_HOME/bin' >> ~/.bash_profile
. ~/.bash_profile
echo 'Check JDK version'
java -version
echo "** DONE! **"


echo "===================================="
echo "||       INSTALL MARIADB 10.1     ||"
echo "===================================="

if [ $(id -u) != "0" ]; then
	printf "You need to use the root account"
	exit
fi

if [[ $(arch) != "x86_64" ]] ; then
	echo "Script only works on CentOS 7 64bit."
	exit
fi

timedatectl set-timezone Asia/Ho_Chi_Minh

export pkg1=$(rpm -qa| grep MariaDB-server)
if [[ "$pkg1" == *"MariaDB-server-10.1."*  ]];then
  echo 'MariaDB package... OK!' 
else
	
	#Create MariaDB.repo
	touch /etc/yum.repos.d/MariaDB.repo
	echo '[mariadb]' >> /etc/yum.repos.d/MariaDB.repo
	echo 'name = MariaDB' >> /etc/yum.repos.d/MariaDB.repo
	echo 'baseurl = http://yum.mariadb.org/10.1/centos7-amd64/' >>/etc/yum.repos.d/MariaDB.repo
	echo 'gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB' >> /etc/yum.repos.d/MariaDB.repo
	echo 'gpgcheck=1' >> /etc/yum.repos.d/MariaDB.repo
	
	setenforce 0
	yum install MariaDB-server MariaDB-client -y
fi 

export pkg1=$(rpm -qa| grep MariaDB-server)
if [[ "$pkg1" == *"MariaDB-server-10.1."*  ]];then
	systemctl start mariadb
	systemctl enable mariadb
	echo ""
	echo "=========================================="
	echo "||  Create Root password for Database   ||"
	echo "=========================================="
	unset password
	export password=$(echo 'ABCD1234')
	mysql -u root -e "update mysql.user set Password=PASSWORD('$password') where User='root'; flush privileges;"
	mysql -u root -p$password -e "DELETE FROM mysql.user WHERE User='';"
	mysql -u root -p$password -e "DELETE FROM mysql.user WHERE User='root' AND Host NOT IN ('localhost', '127.0.0.1', '::1');"
	mysql -u root -p$password -e "DROP DATABASE IF EXISTS test;"
	mysql -u root -p$password -e "DELETE FROM mysql.db WHERE Db='test' OR Db='test\\_%';"
	mysql -u root -p$password -e "FLUSH PRIVILEGES;"
	echo "** DONE! **"
	echo ""
	echo "=========================="
	echo "||  Configure Database  ||" 
	echo "=========================="
	mkdir /var/log/mysql
	sed -i '/# this is only for the mysqld standalone daemon/d' /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\lower_case_table_names = 1" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\pid-file = /var/lib/mysql/mysql.pid" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\socket = /var/lib/mysql/mysql.sock" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\basedir = /usr" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\datadir = /var/lib/mysql" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\tmpdir = /tmp" /etc/my.cnf.d/server.cnf
	sed -i "/mysqld/ a\binlog_format = ROW" /etc/my.cnf.d/server.cnf
	sed -i '/mysqld/ a\server_id = 1' /etc/my.cnf.d/server.cnf
	sed -i '/mysqld/ a\log-bin = binlog' /etc/my.cnf.d/server.cnf
	sed -i '/mysqld/ a\log_error = /var/log/mysql/mysql.log' /etc/my.cnf.d/server.cnf
	ln -s /etc/my.cnf.d/server.cnf /etc/my.cnf > /dev/null 2>&1
	echo "** DONE! **"

	echo "=========================="
	echo "||   Import OpenCPS DB  ||"
	echo "=========================="
	cd /tmp && curl -J -O --insecure https://drive.fds.vn/index.php/s/HGeTQcIAwu7yRlJ/download
	mysql -uroot -pABCD1234 -e "create database opencps;"
	mysql -uroot -pABCD1234 opencps < opencps.sql && rm -rf opencps.sql
	echo "** DONE! **"

	echo "=================================="
	echo "|| Download and Extract Liferay ||"
	echo "=================================="
	cd /opt && curl -J -O --insecure https://drive.fds.vn/index.php/s/AsEbWs0z7ugoL7m/download && tar zxf jserver.tar.gz
	cp /opt/jserver/jboss-7.1.3/standalone/lib/ecj.jar /usr/java/apache-ant-1.9.7/lib
	cp /opt/jserver/jboss-7.1.3/standalone/lib/ivy.jar /usr/java/apache-ant-1.9.7/lib
	echo "** DONE! **"

else
	echo 'There are something wrong with install MariaDB-Server, please try again!'
fi

echo ''
echo '----------------Result-------------------'
echo '- Installed Oracle JDK 7u79			    DONE!'
echo '- Installed Ant 1.9.7				    DONE!'
echo '- Installed MariaDB Server                            DONE!'
echo '- Created and Imported data into OpenCPS Database     DONE!'
echo '- Downloaded Liferay Bundle Jboss (/opt/jserver)	    DONE!'
echo '- Root Database password: '$password


