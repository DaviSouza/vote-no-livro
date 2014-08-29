/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;
import voto.dao.LivroDao;
import voto.dao.imp.LivroDaoImp;
import voto.model.Livro;
import voto.util.CriterioOrdenacao;

/**
 *
 * @author Davi Souza
 */
public class LivroAction extends ActionSupport {

    CriterioOrdenacao CRITERIO = new CriterioOrdenacao("cdLivro");
    @Valid
    private Livro livro;
    private File livroImage;
    private String livroImageFileName;
    private LivroDao livroDao = new LivroDaoImp();
    private List<Livro> livroList = new ArrayList<Livro>();

    public String welcome() {
        getLivroById();
        return SUCCESS;
    }

    private void getLivroById() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String paramCdUsuar = request.getParameter("cdLivro");
        if (paramCdUsuar != null) {
            Integer cdLivro = new Integer(request.getParameter("cdLivro"));
            livro = livroDao.getById(Livro.class, cdLivro);
            livro.setUrlImage("http://voting-dsouza7.rhcloud.com/img/"+livro.getNlLivro());

        }
    }

    public String updateOrSave() {
        boolean flagError = false;
        if (livro.getNmLivro().length() == 0) {
            addFieldError("nameBooke", "Nome obrigatório.");
            flagError = true;
        }
        if (livro.getTxLivro().length() == 0) {
            addFieldError("textBook", "Descrição é obrigatória.");
            flagError = true;
        }

        if (this.livroImageFileName == null || this.livroImageFileName.length() == 0) {
            addFieldError("imagesBook", "Imagem é obrigatória.");
            flagError = true;
        }

        if (flagError) {
            return "fieldError";
        }

        if (livro != null) {
            try {
                criaArquivo();
                livroDao.updateOrSave(livro);
                montaListVotacao();
                return SUCCESS;
            } catch (Exception ex) {
                Logger.getLogger(LivroAction.class.getName()).log(Level.SEVERE, null, ex);
                return "error";
            }

        } else {
            return "error";
        }
    }

    private void fillList() {
        livroList = livroDao.todos(Livro.class, CRITERIO);
    }

    public String list() {
        fillList();
        return SUCCESS;
    }

    public String deletaLivro() {
        try {
            getLivroById();
            livroDao.excluir(livro);
            fillList();
            montaListVotacao();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return SUCCESS;
    }

    private void montaListVotacao() {
        livroList = livroDao.todos(Livro.class, CRITERIO);
        Collections.shuffle(livroList);
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        request.getSession().setAttribute("livroList", livroList);
    }

    public void criaArquivo() throws Exception {//String fileName

        String IMAGEM = "/var/lib/openshift/53c867224382ecd31b000473/app-root/runtime/dependencies/jbossews/webapps/img/";//System.getenv("OPENSHIFT_DATA_DIR")+ "/img/";//context.getRealPath("/") + "\\img\\";
        try {
            try {
                File fileToCreate = new File(IMAGEM, this.livroImageFileName);
                FileUtils.copyFile(this.livroImage, fileToCreate);
            } catch (Exception e) {
                throw e;
            }
            livro.setNlLivro(livroImageFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public LivroDao getLivroDAO() {
        return livroDao;
    }

    public void setLivroDAO(LivroDao livroDAO) {
        this.livroDao = livroDAO;
    }

    public List<Livro> getLivroList() {
        return livroList;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getLivroImageFileName() {
        return livroImageFileName;
    }

    public void setLivroImageFileName(String livroImageFileName) {
        this.livroImageFileName = livroImageFileName;
    }

    public File getLivroImage() {
        return livroImage;
    }

    public void setLivroImage(File livroImage) {
        this.livroImage = livroImage;
    }

}
