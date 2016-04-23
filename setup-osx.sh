
# Copy files.
echo "Copying configuration files ...."

# Copy glassfish-resources.xml
mkdir -p Logica/setup
cp config-files/logica/setup/glassfish-resources.xml Logica/setup/
echo "Copied logica/setup/glassfish-resources.xml"

# Copy persistence.xml
mkdir -p Logica/src/conf
cp config-files/logica/src/conf/persistence.xml Logica/src/conf/persistence.xml
echo "Copied logica/src/conf/persistence.xml"

# Copy glassfish-resources.xml
mkdir -p Logica/web/WEB-INF/
cp config-files/logica/web/WEB-INF/glassfish-resources.xml Logica/web/WEB-INF/glassfish-resources.xml
echo "Copied logica/web/WEB-INF/glassfish-resources.xml"

# Copy private.xml
mkdir -p Presentacion/nbproject/private/
cp config-files/presentacion/nbproject/private/private.xml Presentacion/nbproject/private/
echo "Copied presentacion/nbproject/private/private.xml"

# Copy project.properties
mkdir -p Logica/nbproject/
cp config-files/logica/nbproject/project.properties Logica/nbproject/project.properties
echo "Copied Logica/nbproject/project.properties"

# Copy project.properties
mkdir -p Presentacion/nbproject
cp -p config-files/presentacion/nbproject/project.properties Presentacion/nbproject/project.properties
echo "Copied Presentacion/nbproject/project.properties"

echo "Finished copying configuration files"
