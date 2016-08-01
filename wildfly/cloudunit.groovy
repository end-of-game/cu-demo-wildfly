def callAction(args) {

    print 'sed "s/#APPNAME/${BRANCH_NAME}${BUILD_ID}/g" ' + "${args} > ${args}.1"
    sh 'sed "s/#APPNAME/${BRANCH_NAME}${BUILD_ID}/g" ' + "${args} > ${args}.1"

    sh "cat ${args}.1" 
    java "-jar cu-cli/CloudUnitCLI.jar --cmdfile ${args}.1"
    sh "rm -f ${args}.1"
}

def install_cli() {
    // sh "wget https://github.com/Treeptik/cloudunit/releases/download/1.0/CloudUnitCLI.jar -O /tmp/cloudunit-cli.jar"
}

def mvn(args) {
    sh "${tool 'M3'}/bin/mvn ${args}"
}

def java(args) {
    sh "${tool 'JAVA8'}/bin/java ${args}"
}

this