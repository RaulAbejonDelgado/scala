import com.raul.scala.api.ControlerDemo
import javax.servlet.ServletContext
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {
    import org.apache.log4j.PropertyConfigurator
    val log4jConfPath = "/path/to/log4j.properties"
    PropertyConfigurator.configure(log4jConfPath)
    // mount servlets like this:
    context mount (new ControlerDemo, "/*")
  }
}
