package facts;

import  org.junit.jupiter.api.Assertions;

import org.junit.*;

public class FactListTestspace
{
	
	private FactList fl;
    private String filelocation = "C:\\Users\\phili\\eclipse-workspace\\facts\\src\\main\\java\\facts\\data\\facts.xml";

    @Before
    public void setup()
    {
        Parser parser = new Parser (filelocation);
        fl = parser.getFactList();
    }  
    
    
    @Test
    public void SearchTestAuthor()
    {
    	FactList SearchFacts = fl.search("rob", FactSearchMode.AUTHOR_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("Robert L. Glass", SearchFacts.get(0).getAuthor());
    }
    
    @Test
    public void SearchTestTxtVal()
    {
    	FactList SearchFacts = fl.search("The working environment has a profound impact on productivity and quality.", FactSearchMode.TEXT_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("The working environment has a profound impact on productivity and quality.", SearchFacts.get(0).getText());
    	
    }
    
    @Test
    public void SearchTestTypeVal()
    {
    	FactList SearchFacts = fl.search("fact", FactSearchMode.TYPE_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("Fact", SearchFacts.get(0).getType());
    }
    
    @Test
    public void SearchTestAllAu()
    {
    	FactList SearchFacts = fl.search("Robert", FactSearchMode.ALL_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("Robert L. Glass", SearchFacts.get(0).getAuthor());    	
    }
    
    @Test
    public void SearchTestAllTx()
    {
    	FactList SearchFacts = fl.search("The working environment has a profound impact on productivity and quality.", FactSearchMode.ALL_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("The working environment has a profound impact on productivity and quality.", SearchFacts.get(0).getText());	
    }
    
    @Test
    public void SearchTestAllTy()
    {
    	FactList SearchFacts = fl.search("fact", FactSearchMode.ALL_VAL);
    	
    	Assertions.assertTrue(SearchFacts.getSize() > 0);
    	Assertions.assertEquals("Fact", SearchFacts.get(0).getType());
   	
    }
    
    
    
     
    

}
