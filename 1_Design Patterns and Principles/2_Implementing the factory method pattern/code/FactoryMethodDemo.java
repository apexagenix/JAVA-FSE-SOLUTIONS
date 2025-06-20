interface Document 
{
    void open();
}
class WordDocument implements Document 
{
    public void open() 
    {
        System.out.println("Opening a Word Document.");
    }
}
class PdfDocument implements Document 
{
    public void open() 
    {
        System.out.println("Opening a PDF Document.");
    }
}
class ExcelDocument implements Document 
{
    public void open() 
    {
        System.out.println("Opening an Excel Document.");
    }
}
abstract class DocumentFactory 
{
    public abstract Document createDocument();
}
class WordFactory extends DocumentFactory 
{
    public Document createDocument() 
    {
        return new WordDocument();
    }
}
class PdfFactory extends DocumentFactory 
{
    public Document createDocument() 
    {
        return new PdfDocument();
    }
}
class ExcelFactory extends DocumentFactory 
{
    public Document createDocument() 
    {
        return new ExcelDocument();
    }
}
public class FactoryMethodDemo 
{
    public static void main(String[] args) 
    {
        DocumentFactory wordFactory = new WordFactory();
        Document word = wordFactory.createDocument();
        word.open();
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        DocumentFactory excelFactory = new ExcelFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}
