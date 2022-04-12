#!/bin/bash
mysql -u root -p8b03005ef88c426498523bbe0757d101 < /usr/local/bin/init-db/schema.sql
exit $?