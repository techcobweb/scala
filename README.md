# Scala

This material relates to learning about and messing around with Scala

- Presentation is [here](https://techcobweb.github.io/scala/presentations/session-01/index.html)

# Where to start

- `cd example1` to dive into the hello world example
- `sbt` to start up the build System
  - `clean` to flush out built artifacts
  - `test` to build and test everything
  - `exit` to exit the sbt shell


# Things to note

# To build and run tests whenever anything changes
```
sbt "~ ;clean ;test"
```
Using the above syntax causes a build and test demon to be started. It looks for changed files, and re-runs compile and test phases when it notices anything.

# Other stuff

### Accreditation
This work, "scala" is licensed under CC BY 3.0 by Mike Cobbett.

### License
See [here](./LICENSE.md)
