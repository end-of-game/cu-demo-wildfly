def cloudunit

stage "Init SCM"
node {
    checkout scm
    cloudunit = load 'cloudunit.groovy'
    cloudunit.install_cli()
}

stage "Build application EAR"
node {
    cloudunit.mvn 'clean package -o'
}

stage "Create CU-Server"
node {
    cloudunit.callAction 'cu-cli/create-env'
}

stage "Deploy app"
node {
    cloudunit.callAction 'cu-cli/deploy-app'
}

