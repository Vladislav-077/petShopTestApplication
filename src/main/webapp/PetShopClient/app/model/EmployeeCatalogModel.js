Ext.define('EmployeeCatalog.model.EmployeeCatalogModel', {
    extend: 'Ext.data.Model',
    fields: ['id','name', 'lastName','age','positionName'],
    proxy: {
        type: 'rest',
        api: {
            search: 'http://localhost:8081/employee/name={id}&?Access-Control-Request-Headers=Access-Control-Allow-Origin',
            create: 'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin',
            read: 'http://localhost:8081/employee/?Access-Control-Request-Headers=Access-Control-Allow-Origin',
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
            writeAllFields: true,
            writeRecordId: false
        }

    }
});
