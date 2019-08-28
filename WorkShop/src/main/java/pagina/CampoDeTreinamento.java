package pagina;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CampoDeTreinamento {

	@Ignore
	@Test
	public void cadastro1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luisg\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("file:///C:/Users/luisg/eclipse-workspace/WorkShop/src/main/resources/componentes.html");
		
		WebElement nome = driver.findElement(By.id("elementosForm:nome"));
		WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		WebElement sexoM = driver.findElement(By.id("elementosForm:sexo:0"));
		WebElement comida = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		WebElement comida2 = driver.findElement(By.id("elementosForm:comidaFavorita:0"));
		
		nome.clear();
		nome.sendKeys("Luís");
		Thread.sleep(2000);
		
		sobrenome.clear();
		sobrenome.sendKeys("Bento");
		
		Thread.sleep(2000);
		sexoM.click();
		Thread.sleep(2000);
		comida.click();
		comida2.click();
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByValue("superior");
		
		Thread.sleep(2000);
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		WebElement praticaEsportes = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select(praticaEsportes);
		combo2.selectByValue("futebol");
		
		Assert.assertEquals("Futebol", combo2.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		WebElement sugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		
		sugestoes.clear();
		sugestoes.sendKeys("Boxe");
		
		Thread.sleep(2000);
		
		
		
		WebElement cadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
		cadastrar.click();
		
		Thread.sleep(5000);
		driver.quit();
}
	@Test
	@Ignore
	public void brincarAlert() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luisg\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("file:///C:/Users/luisg/eclipse-workspace/WorkShop/src/main/resources/componentes.html");
		
		
		
		WebElement clickAlert = driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[1]/td[3]/input"));
		clickAlert.click();
		
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		
		Assert.assertEquals("Francisco", texto);
		alert.accept();
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	@Test
	public void desafio() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luisg\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("file:///C:/Users/luisg/eclipse-workspace/WorkShop/src/main/resources/componentes.html");
		
		WebElement nome = driver.findElement(By.id("elementosForm:nome"));
		nome.clear();

		WebElement cadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
		cadastrar.click();
		
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		
		Assert.assertEquals("Nome eh obrigatorio", texto);
		alert.accept();
		
		nome.sendKeys("Luís");
		
		WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		
		sobrenome.clear();
		cadastrar.click();
		
		alert = driver.switchTo().alert();
		texto = alert.getText();
		
		Assert.assertEquals("Sobrenome eh obrigatorio", texto);
		alert.accept();
		
		sobrenome.sendKeys("Bento");
		cadastrar.click();
		
		alert = driver.switchTo().alert();
		texto = alert.getText();
		
		Assert.assertEquals("Sexo eh obrigatorio", texto);
		alert.accept();
		
		WebElement sexoM = driver.findElement(By.id("elementosForm:sexo:0"));
		
		sexoM.click();
		
		WebElement comida = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		WebElement comida2 = driver.findElement(By.id("elementosForm:comidaFavorita:0"));
		
		comida.click();
		comida2.click();
		
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByValue("superior");
		
		
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
	
		WebElement praticaEsportes = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select(praticaEsportes);
		combo2.selectByValue("futebol");
		
		Assert.assertEquals("Futebol", combo2.getFirstSelectedOption().getText());
		
		
		WebElement sugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		
		sugestoes.clear();
		sugestoes.sendKeys("Boxe");
		
		cadastrar.click();
		
		WebElement cadastrou = driver.findElement(By.xpath("//*[@id=\"resultado\"]/span"));
		
		Assert.assertEquals("Cadastrado!", cadastrou.getText());
		
		WebElement confereNome = driver.findElement(By.xpath("//*[@id=\"descNome\"]/span"));
		
		Assert.assertEquals("Luís", confereNome.getText());
		
		WebElement confereSobrenome = driver.findElement(By.xpath("//*[@id=\"descSobrenome\"]/span"));
		
		Assert.assertEquals("Bento", confereSobrenome.getText());
		
		WebElement confereSexo = driver.findElement(By.xpath("//*[@id=\"descSexo\"]/span"));
		
		Assert.assertEquals("Masculino", confereSexo.getText());
		
		WebElement confereComida = driver.findElement(By.xpath("//*[@id=\"descComida\"]/span"));
		
		Assert.assertEquals("Carne Pizza", confereComida.getText());
		
		WebElement confereEscolaridade = driver.findElement(By.xpath("//*[@id=\"descEscolaridade\"]/span"));
		
		Assert.assertEquals("superior", confereEscolaridade.getText());
		
		WebElement confereEsportes = driver.findElement(By.xpath("//*[@id=\"descEsportes\"]/span"));
		
		Assert.assertEquals("Futebol", confereEsportes.getText());
		
		WebElement confereSugestoes = driver.findElement(By.xpath("//*[@id=\"descSugestoes\"]/span"));
		
		Assert.assertEquals("Boxe", confereSugestoes.getText());
		
		driver.quit();
		
	}
}
