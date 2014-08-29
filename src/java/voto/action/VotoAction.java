/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;
import voto.dao.LivroDao;
import voto.dao.imp.LivroDaoImp;
import voto.dao.imp.VotadosDaoImp;
import voto.dao.imp.VotliDaoImp;
import voto.model.Livro;
import voto.model.Votli;
import voto.util.CriterioOrdenacao;
import voto.util.Votados;

/**
 *
 * @author Davi Souza
 */
public class VotoAction extends ActionSupport {

    CriterioOrdenacao CRITERIO = new CriterioOrdenacao("cdLivro");
    private LivroDao livroDao = new LivroDaoImp();
    private List<Livro> livroList = new ArrayList<Livro>();
    private List<Livro> livroListVotados = new ArrayList<Livro>();
    private List<Votados> rankingListVotados = new ArrayList<Votados>();
    @Valid
    private Livro livro1;
    @Valid
    private Livro livro2;

    //fazer a lista de votados
    private void removeDaLivroList(Integer cdLivro) {
        livroList = (List<Livro>) getRequest().getSession().getAttribute("livroList");
        Object obj = getRequest().getSession().getAttribute("votados");
        if (obj != null) {
            livroListVotados = (List<Livro>) obj;
        }
        for (Livro livro : livroList) {
            if (cdLivro.equals(livro.getCdLivro())) {
                livroListVotados.add(livro);
                livroList.remove(livro);
                getRequest().getSession().setAttribute("livroList", livroList);
                getRequest().getSession().setAttribute("votados", livroListVotados);
                break;
            }
        }
    }

    public String maisVotados() throws Exception {
        Integer total = new VotliDaoImp().totalRegistros(Votli.class);
        String sql = "select distinct livro.cd_livro, livro.nm_livro as nome, livro.nl_livro as url,"
                + "(SELECT COUNT(e.cd_livro) FROM votli e where e.cd_livro = livro.cd_livro) as votos "
                + "from livro, votli where votli.cd_livro = livro.cd_livro";
        Connection con = new VotadosDaoImp().getConnection(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Double percent = 0d;
        while (rs.next()) {
            percent = (rs.getInt("votos") * 100d) / total.doubleValue();
            rankingListVotados.add(new Votados(rs.getString("nome"), rs.getString("url"), percent.intValue()));
        }
        stmt.close();
        con.close();
        return SUCCESS;
    }

    public String voted() throws Exception {
        HttpServletRequest request = getRequest();
        Integer cdLivro = new Integer(request.getParameter("cdLivro"));
        removeDaLivroList(cdLivro);
        return SUCCESS;
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    }

    public String welcome() {

        livroList = (List<Livro>) getRequest().getSession().getAttribute("livroList");
        if (livroList == null || livroList.isEmpty()) {
            montaListVotacao();
        }
        if (livroList.size() > 1) {
            Collections.shuffle(livroList);
            livro1 = livroList.get(0);
            livro2 = livroList.get(1);
        } else {
            montaListVotacao();
        }
        return SUCCESS;
    }

    private void montaListVotacao() {
        livroList = livroDao.todos(Livro.class, CRITERIO);
        getRequest().getSession().setAttribute("livroList", livroList);
    }

    public Livro getLivro1() {
        return livro1;
    }

    public void setLivro1(Livro livro1) {
        this.livro1 = livro1;
    }

    public Livro getLivro2() {
        return livro2;
    }

    public void setLivro2(Livro livro2) {
        this.livro2 = livro2;
    }

    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    public List<Livro> getLivroListVotados() {
        return livroListVotados;
    }

    public void setLivroListVotados(List<Livro> livroListVotados) {
        this.livroListVotados = livroListVotados;
    }

    public List<Votados> getRankingListVotados() {
        return rankingListVotados;
    }

    public void setRankingListVotados(List<Votados> rankingListVotados) {
        this.rankingListVotados = rankingListVotados;
    }
}
