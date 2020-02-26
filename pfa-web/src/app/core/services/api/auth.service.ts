import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthUser } from '../../models/auth-user';
import { ApiBaseService } from './api-base.service';


@Injectable({ providedIn: 'root' })
export class AuthService {
    public currentUser: AuthUser;

    constructor(private apiService: ApiBaseService) {

    }

    getCurrentUser(): AuthUser {
        return this.currentUser;
    }

    async login(username: string, password: string) {
        debugger;
        this.currentUser = await this.apiService.post<AuthUser>("/auth/login", {
            nombre: username,
            contraseña: password
        });

        
        return this.currentUser;


    }



}