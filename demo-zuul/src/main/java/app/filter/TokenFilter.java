package app.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TokenFilter extends ZuulFilter {
	
	

	//filter需要执行的具体操作
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String sessionId =request.getHeader("token");

        if(sessionId == null){
        	
            if(null ==sessionId){
            	if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    return null;
                }
                if (!StringUtils.isBlank(sessionId)) {
                    ctx.setSendZuulResponse(false);//不对其进行路由
                    ctx.setResponseStatusCode(401);
                    ctx.setResponseBody("{\"status\":401,\"msg\":\"user is not login!\",\"token\":\"0\"}");
                    ctx.getResponse().setContentType("text/html;charset=UTF-8");
                }else{
                     ctx.setSendZuulResponse(true);// 对该请求进行路由
                     ctx.setResponseStatusCode(200); // 返回200正确响应
                }
            }
        	
        }else{
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"status\":401,\"msg\":\"user is not login!\",\"token\":\"0\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
        }
        
        return null;
    }
    
    //表示是否需要执行该filter，true表示执行，false表示不执行
    @Override
    public boolean shouldFilter() {
    	
    	 RequestContext ctx = RequestContext.getCurrentContext();
         HttpServletRequest request = ctx.getRequest();
         String requestUrl = request.getRequestURL().toString();
         System.out.println("zl:"+request.getSession().getAttribute("username"));
         // 请求URL内不包含login或join则需要经过该过滤器，即执行run()
         return !requestUrl.contains("login");
 
    }

    @Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低
    }

    @Override
    public String filterType() {
        return "pre";// 前置过滤器//定义filter的类型，有pre、route、post、error四种
    }

} 
