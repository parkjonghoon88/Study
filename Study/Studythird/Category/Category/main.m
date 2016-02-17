//
//  main.m
//  Category
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NSString+JHExtension.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        NSString *name = @"sim jae sik";
        
        NSLog(@"normal name > %@",name);            // "sim jae sik";
        NSLog(@"jh name > %@",[name jhString]);     // "JHsim jae sik";
        NSLog(@"normal name > %@",name);            // "sim jae sik";
        NSLog(@"%@", [[name uppercaseString] jhString]);       // "SIM JAE SIK";
        
        NSArray *component = [[name uppercaseString] componentsSeparatedByString:@" "];
        for (id each in component) {
            NSLog(@"%@",[each jhString]);
        }
    }
    return 0;
}
