#### Database Setup (Copy and Paste it to your terminal)

DB=teachers_spring; DB_USER=teachersapp; DB_PW=P@ssw0rd; mysql -uroot -p -e "CREATE DATABASE $DB; CREATE USER '$DB_USER'@'localhost' IDENTIFIED BY '$DB_PW'; CREATE USER '$DB_USER'@'%' IDENTIFIED BY '$DB_PW'; GRANT ALL PRIVILEGES ON $DB.* TO '$DB_USER'@'localhost' WITH GRANT OPTION; GRANT ALL PRIVILEGES ON $DB.* TO '$DB_USER'@'%' WITH GRANT OPTION; FLUSH PRIVILEGES;"

