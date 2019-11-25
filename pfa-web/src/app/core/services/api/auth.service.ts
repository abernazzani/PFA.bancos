import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthUser } from '../../models/auth-user';

@Injectable({ providedIn: 'root' })
export class AuthService {
    private currentUser: AuthUser;

    constructor(private httpClient: HttpClient) {

    }

    getCurrentUser(): AuthUser {
        return this.currentUser;
    }

    login() {
        this.currentUser = {
            lastName: "Desiderio",
            name: "Brian",
            username: "bdesiderio",
        };
    }
}