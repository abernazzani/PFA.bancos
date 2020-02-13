import { Component, OnInit, Input } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Usuario } from 'src/app/core/models/usuario';
import { UsuariosService } from 'src/app/core/services/api/usuarios.service';

@Component({
    selector: 'bandas-edit',
    templateUrl: 'edit.component.html'
})

export class UsuariosEditComponent implements OnInit {
    loading: boolean;

    @Input()
    codigo: number;

    protected usuario: Usuario;

    constructor(private usuariosService: UsuariosService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo|| params["id"];
            //debugger;
            if (this.codigo) {
                this.usuario = await this.usuariosService.getPorId(this.codigo);
                
            } else {
                this.usuario = new Usuario();
            }
        });

    }

    async create() {
        await this.usuariosService.create(this.usuario);
        this.activeModal.close(ModalResult.Ok);
    }

    async update() {
        await this.usuariosService.update(this.usuario);
        this.activeModal.close(ModalResult.Ok);
    }

    async delete() {
        await this.usuariosService.delete(this.usuario.id);
        this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back();
        }
    }
}