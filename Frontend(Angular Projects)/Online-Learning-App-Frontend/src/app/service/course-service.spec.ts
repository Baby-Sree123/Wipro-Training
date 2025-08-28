import { TestBed } from '@angular/core/testing';
import { Userservice } from './userservice';
import { Courseservice } from './course-service';

describe('Courseservice', () => {
  let service:Courseservice;

  beforeEach(()=>{
    TestBed.configureTestingModule({});
    service = TestBed.inject(Courseservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
