Ext.define('EmployeeCatalog.store.EmployeeCatalogStore', {
    extend: 'Ext.data.Store',
    requires : [
        'EmployeeCatalog.model.EmployeeCatalogModel'
    ],
    model: 'EmployeeCatalog.model.EmployeeCatalogModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
        type: 'rest',
        api: {
            create: 'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin',
            read:   'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin',
            destroy: 'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin',
            update: 'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
});
