package akihyro.cloudprintconsole.service;


import java.net.URI;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import akihyro.cloudprintconsole.CloudPrintConsoleSession;
import akihyro.cloudprintconsole.api.CloudPrintFacade;
import lombok.Getter;
import lombok.Setter;

/**
 * ログインサービス。
 */
@Named
@RequestScoped
@Path("/login")
public class LoginService {

    /** URI情報 */
    @Context
    UriInfo uriInfo;

    /** ファサード */
    @Inject
    CloudPrintFacade facade;

    /** セッション */
    @Inject
    CloudPrintConsoleSession session;

    /** 認可コード */
    @QueryParam("code")
    @Getter @Setter
    private String authCode;

    /**
     * ログインする。
     *
     * @return プリンタリストへリダイレクト。
     * @throws Exception エラー。
     */
    @GET
    public Response login() throws Exception {

        // 未認証なら認証情報を得る
        if (!session.hasCredential()) {
            session.setCredential(facade.takeCredential(authCode));
        }

        // プリンタリストへリダイレクトする
        URI redirectURI = uriInfo.getBaseUriBuilder().path(PrintersService.class).build();
        return Response.seeOther(redirectURI).build();
    }

}
