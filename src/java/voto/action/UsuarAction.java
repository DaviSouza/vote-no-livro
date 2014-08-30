/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;
import voto.dao.UsuarDao;
import voto.dao.imp.UsuarDaoImp;
import voto.dao.imp.VotliDaoImp;
import voto.model.Livro;
import voto.model.Usuar;
import voto.model.Votli;
import voto.model.VotliPK;
import voto.util.CriterioOrdenacao;

/**
 *
 * @author Davi Souza
 */
public class UsuarAction extends ActionSupport {

    CriterioOrdenacao CRITERIO = new CriterioOrdenacao("cdUsuar");
    @Valid
    private Usuar usuar;
    private UsuarDao usuarDao = new UsuarDaoImp();
    private List<Usuar> usuarList = new ArrayList<Usuar>();

    public String welcome() {
        getUsuarById();
        return SUCCESS;
    }

    private void getUsuarById() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String paramCdUsuar = request.getParameter("cdUsuar");
        if (paramCdUsuar != null) {
            Integer cdLivro = new Integer(request.getParameter("cdUsuar"));
            usuar = usuarDao.getById(Usuar.class, cdLivro);
        }
    }

    public String updateOrSave() {
        if (usuar != null) {
            boolean flagError = false;
            if (usuar.getNmUsuar().length() == 0) {
                addFieldError("nameUser", getText("label.name.required"));
                flagError = true;
            }
            if (usuar.getEmUsuar().length() == 0) {
                addFieldError("emailUser", getText("label.email.required"));
                flagError = true;
            }
            if (flagError) {
                return "fieldError";
            }
            usuarDao.updateOrSave(usuar);
            updateOrSaveVotos();
            return SUCCESS;
        } else {
            return "error";
        }
    }

    public String list() {
        usuarList = usuarDao.todos(Usuar.class, CRITERIO);
        return SUCCESS;
    }

    public String deletaUsuar() {
        try {
            getUsuarById();
            deleteInVotli();
            usuarDao.excluir(usuar);
            list();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return SUCCESS;
    }

    private void deleteInVotli() throws SQLException {
        new UsuarDaoImp().deleteInVotli(usuar.getCdUsuar());
    }

    public void updateOrSaveVotos() {
        List<Livro> livroListVotados = (List<Livro>) getRequest().getSession().getAttribute("votados");
        if (!livroListVotados.isEmpty()) {
            VotliDaoImp votliDaoImp = new VotliDaoImp();
            Votli votli;
            VotliPK votliPK;
            for (Livro livro : livroListVotados) {
                votliPK = new VotliPK(usuar.getCdUsuar(), livro.getCdLivro());
                votli = new Votli(votliPK);
                votliDaoImp.updateOrSave(votli);
            }
        }
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    }

    public Usuar getUsuar() {
        return usuar;
    }

    public void setUsuar(Usuar usuar) {
        this.usuar = usuar;
    }

    public UsuarDao getUsuarDAO() {
        return usuarDao;
    }

    public void setUsuarDAO(UsuarDao usuarDAO) {
        this.usuarDao = usuarDAO;
    }

    public List<Usuar> getUsuarList() {
        return usuarList;
    }
}
