import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Usuario } from 'src/app/core/models/usuario';
import { AuthService } from 'src/app/core/services/api/auth.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'inicio-index',
    templateUrl: 'index.component.html'
})

export class InicioIndexComponent implements OnInit {
    
    //constructor() { }
    constructor(public authService: AuthService,private router: Router,
        private activatedRoute: ActivatedRoute,) {
    
    }
    usuario: Usuario;

    async ngOnInit() {
        


    }

    // edit(){

    // }

    async logout() {
        
            
    }


    
    edit(){

    }

}