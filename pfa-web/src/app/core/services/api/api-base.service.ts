import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class ApiBaseService {
    constructor(private httpClient: HttpClient) {

    }

    private getFullUrl(resourceUri: string) {
        return `${environment.apiURL}/${resourceUri}`;
    }

    async post(resourceUri: string, body: any | null, options?: {
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        observe?: 'body';
        params?: HttpParams | {
            [param: string]: string | string[];
        };
        reportProgress?: boolean;
        responseType: 'arraybuffer';
        withCredentials?: boolean;
    }) {
        return await this.httpClient.post(this.getFullUrl(resourceUri), body, options).toPromise();
    }

    async get<T>(resourceUri: string, options?: {
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        observe?: 'body';
        params?: HttpParams | {
            [param: string]: string | string[];
        };
        reportProgress?: boolean;
        responseType?: 'json';
        withCredentials?: boolean;
    }) {
        return await this.httpClient.get<T>(this.getFullUrl(resourceUri), options).toPromise();
    }

    async put<T>(resourceUri: string, body: any | null, options?: {
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        observe?: 'body';
        params?: HttpParams | {
            [param: string]: string | string[];
        };
        reportProgress?: boolean;
        responseType: 'arraybuffer';
        withCredentials?: boolean;
    }) {
        return await this.httpClient.put(this.getFullUrl(resourceUri), body, options).toPromise();
    }

    async delete(resourceUri: string, options?: {
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        observe?: 'body';
        params?: HttpParams | {
            [param: string]: string | string[];
        };
        reportProgress?: boolean;
        responseType: 'arraybuffer';
        withCredentials?: boolean;
    }) {
        await this.httpClient.delete(this.getFullUrl(resourceUri), options).toPromise();
    }

}