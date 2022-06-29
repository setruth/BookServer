import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("war")
}

group = "com.setruth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
    //springMVC依赖
    implementation("org.springframework:spring-webmvc:5.3.20")
    implementation("org.springframework:spring-jdbc:5.3.20")
    //mybatis依赖
    implementation("org.mybatis:mybatis-spring:2.0.7")
    implementation("org.mybatis:mybatis:3.5.6")
    //JSON解析依赖
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    //Web依赖
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    //Kotlin依赖
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    //测试依赖
    testImplementation("junit:junit:4.13.2")
//    implementation("org.springframework.spring-test:3.1.2.RELEASE")
    //数据库依赖
    implementation("mysql:mysql-connector-java:8.0.29")
    implementation("com.alibaba:druid:1.2.11")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}