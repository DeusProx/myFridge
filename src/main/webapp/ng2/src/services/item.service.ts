import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { Item } from 'src/models/item';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class ItemService {
    private itemsAPIEndpoint:string = "/myFridge/api/items" // URL to webapi
    constructor (private http: Http) {}
    

    public getItems(): Observable<Item[]> {
        return this.http.get(this.itemsAPIEndpoint)
            .map(res => res.json())
            .catch(this.handleError)
    }

    public addItem(item: Item): Observable<Boolean> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.itemsAPIEndpoint, item, options)
                    .map(res => res.status == 201 )
                    .catch(this.handleError);
    }

    public removeItem(id: number): Observable<Boolean> {
        return this.http.delete(this.itemsAPIEndpoint + "/" + id)
                    .map(res => res.status == 200 )
                    .catch(this.handleError);
    }

    private handleError (error: any) {
        // In a real world app, we might use a remote logging infrastructure
        // We'd also dig deeper into the error to get a better message
        let errMsg = (error.message) ? error.message :
        error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}