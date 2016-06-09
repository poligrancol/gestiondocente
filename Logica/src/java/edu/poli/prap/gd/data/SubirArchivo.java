
package src.java.edu.poli.prap.gd.data;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author alejo
 */

@WebServlet(name = "SubirArchivo", urlPatterns = {"/upload"}) // este tag maneja los nombre y el url pattern
@MultipartConfig //Configuraciones del archivo
public class SubirArchivo extends HttpServlet {
private File uploadFolder;
private final static Logger LOGGER = Logger.getLogger(SubirArchivo.class.getCanonicalName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       processRequest(req,resp); //metodo en el cual se hace el proceso de verificacion, creacio y subida del archivo.
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    @Override
    public void init()
            throws ServletException {
         uploadFolder = new File("D:\\file");
    }
*/

/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            Part p1 = request.getPart("file");
            InputStream is = p1.getInputStream();
            
           
            Part p2 = request.getPart("photoname");
            Scanner s = new Scanner (p2.getInputStream());
            String filename  = s.nextLine(); // read filename from stream
            
            //get filename to use on the server
            String outputfile = this.getServletContext().getRealPath("/");
            FileOutputStream os = new FileOutputStream(outputfile);
            
            //write bytes taken from uploaded file to target file
            int ch = is.read();
            while (ch != -1) {
                os.write(ch);
                ch = is.read();
            }
            os.close();
            out.println("<h3>File uploaded succefully!</h3>");
        }
        catch (Exception ex){
            out.println("Exception -->" + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            out.close();
        }
    } // end of doPost();*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //creates path components to save the file
        final String path = "/WEB-INF/uploads";//La direccion de la carpeta donde se van alojar los archivos
        final String absoluteFilePath = getServletContext().getRealPath(path);//Direccion real para que el servlet funcione.
       
        
        final Part filePart = request.getPart("file");//Obtiene la parte(archivo) desde su nombre;
        final String fileName = getFileName(filePart); //Obtiene el nombrea llamando el metodo getFileName utilizando la parte traida anteriormente.
        
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        //El proceso para subir el archivo a la carpeta deseada
        try {
            out = new FileOutputStream(new File(path/* + File.separator +*/, fileName)); //la direccion final incluyendo el nombre del archivo al final
            filecontent = filePart.getInputStream(); //contenido del archivo 
            
            int read = 0;
            final byte[] bytes = new byte[1024]; //Tamaño permitido para el archivo
            
            while((read = filecontent.read(bytes)) != -1){
                out.write(bytes, 0, read);
            }
            writer.println("New File" + fileName + "created at " + path); //Si todo esta bien escribe lo siguiente
            LOGGER.log(Level.INFO, "file {0} being upload to {1}", new Object[]{fileName, path});
        } catch (FileNotFoundException fne){
            writer.println("<br/> Error:" + fne.getMessage()); //si obtiene la excepcion FileNotFound escribe este mensaje
            
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error {0}", new Object[]{fne.getMessage()});
        } finally {
            if (out != null){
            out.close();
        }
            if(filecontent != null){
                filecontent.close();
            }
            if(writer != null) {
                writer.close();
            }
        }
    }
    //Metodo para obtener el nombre del archivo
    private String getFileName (final Part part){
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part header ={0}", partHeader);
        for(String content: part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(
                content.indexOf('=')+1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
} //end of UpladServelt