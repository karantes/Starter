package br.arantes.admin.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.ListAttribute;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

public class TilesDefinitionsConfig implements DefinitionsFactory {

	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute COMMON_CLEAN = new Attribute("/WEB-INF/layout/classic-clean.jsp");

	public Definition getDefinition(String name, Request tilesContext) {
		return tilesDefinitions.get(name);
	}

	private static void addCommonCleanLayout(String name, String title, String body) {
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("body", new Attribute(body));

		ListAttribute stylesheets = new ListAttribute();

		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/vendors/css/vendors.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/vendors/css/forms/icheck/icheck.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/vendors/css/forms/icheck/custom.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/bootstrap.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/bootstrap-extended.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/colors.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/components.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/core/colors/palette-gradient.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/app-assets/css/pages/login-register.min.css"));
		stylesheets.add(new Attribute("/resources/stack-admin/assets/css/style.css"));
		attributes.put("stylesheets", stylesheets);

		ListAttribute javascripts = new ListAttribute();
		javascripts.add(new Attribute("/resources/plugins/jQuery/jquery-3.3.1.min.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/vendors/js/vendors.min.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/vendors/js/forms/icheck/icheck.min.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/js/core/app-menu.min.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/js/core/app.min.js"));
		javascripts.add(new Attribute("/resources/stack-admin/app-assets/js/scripts/forms/form-login-register.min.js"));
		attributes.put("javascripts", stylesheets);

		tilesDefinitions.put(name, new Definition(name, COMMON_CLEAN, attributes));
	}

	public static void addDefinitions() {

		addCommonCleanLayout("login", "login", "/WEB-INF/jsp/admin/login.jsp");
//			addDefaultLayoutDef("personList", "viewPerson", "/WEB-INF/views/layout/personList.jsp");

	}
}