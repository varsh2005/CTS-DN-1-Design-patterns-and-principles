public class FactoryPattern{
  interface Document{
    void open();
  }
  static class WordDocument implements Document{
    public void open(){
      System.out.println("Opening a Word Document");
    }
  }
  static class PdfDocument implements Document{
    public void open(){
      System.out.println("Opening a PDF Document");
    }
  }
  static class ExcelDocument implements Document{
    public void open(){
      System.out.println("Opening an Excel Document");
    }
  }
  abstract static class DocumentFactory{
    public abstract Document createDocument();
  }
  static class WordDocFactory extends DocumentFactory{
    public Document createDocument(){
      return new WordDocument();
    }
  }
  static class PdfDocFactory extends DocumentFactory{
    public Document createDocument(){
      return new PdfDocument();
    }
  }
  static class ExcelDocFactory extends DocumentFactory{
    public Document createDocument(){
      return new ExcelDocument();
    }
  }

  public static void main(String[] args){
    DocumentFactory wordFac = new WordDocFactory();
    Document wordDoc = wordFac.createDocument();
    wordDoc.open();
    DocumentFactory pdfFac = new PdfDocFactory();
    Document pdfDoc = pdfFac.createDocument();
    pdfDoc.open();
    DocumentFactory excelFac = new ExcelDocFactory();
    Document excelDoc = excelFac.createDocument();
    excelDoc.open();
  }
}
