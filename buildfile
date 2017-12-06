
THIS_VERSION = "1.0.4"

SOURCE = ['src/main/resources',
          'src/main/java' ]

TEST_SOURCE = ['src/main/resources',
          'src/main/java']

XERCES = artifact('org.bluestemsoftware.open.maven.tparty:xerces-impl:jar:2.9.0')

DEPS = [ XERCES ]

desc "HTML Formatting Library"
define "html-writer" do
  project.version = THIS_VERSION
  project.group = "scu"

  test.using :testng

  compile.with(DEPS).from(SOURCE).into('target/classes')
  test.with(DEPS).compile.from(TEST_SOURCE).into('target/test/classes')
  package(:jar)
end

