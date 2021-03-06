import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverLogger extends AbstractWebDriverEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverLogger.class);

    @Override
    public void beforeNavigateTo(String url, WebDriver driver){
        //LOGGER.info("WebDriver navigated to '" + url + "'");
        System.out.println("WebDriver navigated to '" + url + "'");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        //LOGGER.info("WebDriver searched webElement - " + " using locator '" + by + "'");
        System.out.println("WebDriver searched webElement - " + " using locator '" + by + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        //LOGGER.info("WebDriver click on element - " + elementDescription(element));
        System.out.println("WebDriver click on element - " + elementDescription(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        StringBuilder value = new StringBuilder();
        if (keysToSend != null)
            for (CharSequence ch : keysToSend){
                value.append(ch);
            }
        //LOGGER.info("WebDriver will change value " + value + " for element - " + elementDescription(element));
        System.out.println("WebDriver will change value " + value + " for element - " + elementDescription(element));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        StringBuilder value = new StringBuilder();
        if (keysToSend != null)
            for (CharSequence ch : keysToSend){
                value.append(ch);
            }
        //LOGGER.info("WebDriver changed value " + value + " for element - " + elementDescription(element));
        System.out.println("WebDriver changed value " + value + " for element - " + elementDescription(element));
    }

    private String elementDescription(WebElement element) {
        String description = "tag:" + element.getTagName();
        if (element.getAttribute("id") != null) {
            description += " id: " + element.getAttribute("id");
        }
        else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }
        description += " ('" + element.getText() + "')";
        return description;
    }
}
