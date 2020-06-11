node {
   stage('git clone') { // for display purposes  
			checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class:'CheckoutOption',timeout:90],[$class:'CloneOption',depth:1,noTags:false,reference:'',shallow:true,timeout:90]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '1b99f8a5-741e-497c-8c2e-c830fb818feb', url: 'https://github.com/xiaolong199011/eMart_backend/']]])
   }
   stage('Build') {
           //env.JAVA_HOME="${tool 'jdk1.8.0_231'}"
           withMaven(
            maven: 'maven',
            mavenLocalRepo: '.repository') {
                bat "mvn clean install -Dmaven.test.skip=true"
        }
   }
   stage('deploy') {
deploy adapters: [tomcat9(credentialsId: '094bbb3f-6c70-4ebe-8c66-d62fae265400', path: '', url: 'http://localhost:9000')], contextPath: 'api', onFailure: false, jar: 'web/target/*.jar'
   }
}