# Base Starter for Vaadin Flow and OSGi

## Coordinates

### Maven

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>starter.flow.better</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### OSGi

```
Bundle Symbolic Name: com.example.starter.flow.better
Version             : 1.0.0
```

### Feature-Coordinate

```
"bundles": [
   {
    "id": "com.example:starter.flow.better:1.0-SNAPSHOT"
   }
]
```

## Components

### com.example.starter.flow.better.osgi.IconResource - *state = enabled, activation = immediate*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|com.vaadin.flow.osgi.support.OsgiVaadinStaticResource |

#### Properties

No properties.

#### Configuration - *policy = optional*

##### Pid: `com.example.starter.flow.better.osgi.IconResource`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: com.example.starter.flow.better.osgi.IconResource
 * policy:    optional
 */
"com.example.starter.flow.better.osgi.IconResource":{
        //# Component properties
        // none

        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

---

### com.example.starter.flow.better.osgi.VaadinServletRegistration - *state = enabled, activation = immediate*

#### Description

#### Services

No services.

#### Properties

No properties.

#### Configuration - *policy = optional*

##### Pid: `com.example.starter.flow.better.osgi.VaadinServletRegistration`

No information available.

#### Reference bindings

|Attribute |Value |
|--- |--- |
|name |HttpService |
|interfaceName |org.osgi.service.http.HttpService |
|target | |
|cardinality |1..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle |

#### OSGi-Configurator


```
/*
 * Component: com.example.starter.flow.better.osgi.VaadinServletRegistration
 * policy:    optional
 */
"com.example.starter.flow.better.osgi.VaadinServletRegistration":{
        //# Component properties
        // none

        //# Reference bindings
        // "HttpService.target": "(component.pid=*)"


        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

## Licenses

**http://www.apache.org/licenses/LICENSE-2.0**