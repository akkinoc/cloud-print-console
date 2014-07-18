package akihyro.cloudprintconsole.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import akihyro.cloudprintconsole.CloudPrintConsoleSession;
import akihyro.cloudprintconsole.api.CloudPrintFacade;

/**
 * プリンタリストサービス。
 */
@Named
@RequestScoped
@Path("/printers")
public class PrintersService {

    /** ファサード */
    @Inject
    CloudPrintFacade facade;

    /** セッション */
    @Inject
    CloudPrintConsoleSession session;

    /**
     * プリンタをリストアップする。
     *
     * @return 認証ページへリダイレクト。
     * @throws Exception エラー。
     */
    @GET
    @Template(name = "/printers")
    public String printers() throws Exception {
        return "TODO: Printers.";
    }

}