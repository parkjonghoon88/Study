//
//  MaxCommand.m
//  Study2
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//


#import "JHMaxCommand.h"

@implementation JHMaxCommand

#pragma mark - JHCommand.h
-(void)execute:(NSArray *)students
{
    NSInteger beforeData = -1;
    
    
    for(JHStudent *each in students)
    {
        NSInteger tempData = each.studentJumsu;
        
        if(beforeData <0)
        {
            beforeData = tempData;
            
        }
        
        if(beforeData<= tempData)
        {
            beforeData = tempData;
        }
        

    }
    NSLog(@"Max data : %zd " , beforeData);
}

@end

//int beforeData = 0;
//
//for (int i = 0; i < students.size(); i++) {
//    int tempData = students.get(i).getStudentJumsu();
//    
//    if (beforeData <= tempData) {
//        beforeData = tempData;
//    }
//}
//
//System.out.println("Max value is " + beforeData);
